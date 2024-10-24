/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.dao.impl;

import in.gadgethub.dao.ProductDao;
import in.gadgethub.pojo.ProductsPojo;
import in.gadgethub.utility.DBUtil;
import in.gadgethub.utility.IdUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp4ce
 */
public class ProductDaoImpl implements ProductDao{
  
    @Override
    public String addProduct(ProductsPojo product){
        String status="Product Registration Failed !";
        if(product.getPid()==null){
            product.setPid(IdUtil.generateProdId());   
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps=null;
        try{
            ps = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?,?,?,?");
            ps.setString(1, product.getPid());
            ps.setString(2,product.getPname());
            ps.setString(3,product.getPtype());
            ps.setString(4,product.getPinfo());
            ps.setDouble(5,product.getPprice());
            ps.setInt(6, product.getPquantity());
            ps.setBlob(7, product.getPimage());
         
            int count =ps.executeUpdate();
            if(count==1){
                
                status="Product Added Successfull with id -"+product.getPid();
               
            }
            
        }
            catch(SQLException ex){
                    System.out.println("Error in Registered user"+ex);
                    ex.printStackTrace();
                    
                    }
        
        DBUtil.closeStatement(ps);
        return status;
            
            
        }
            
        
  @Override
public String updateProduct(ProductsPojo prevProduct, ProductsPojo updatedProduct) {
    String status = "Product Update Failed!";
    if (prevProduct == null || prevProduct.getPid() == null) {
        return "Previous Product ID is missing!";
    }
 
    try (Connection conn = DBUtil.provideConnection(); 
         PreparedStatement ps = conn.prepareStatement("UPDATE products SET pname = ?, ptype = ?, pinfo = ?, pprice = ?, pquantity = ?, pimage = ? WHERE pid = ?")) {
    
        ps.setString(1, updatedProduct.getPname());
        ps.setString(2, updatedProduct.getPtype());
        ps.setString(3, updatedProduct.getPinfo());
        ps.setDouble(4, updatedProduct.getPprice());
        ps.setInt(5, updatedProduct.getPquantity());
        
      
        if (updatedProduct.getPimage() != null) {
            
            ps.setBlob(6, updatedProduct.getPimage()); 
        } 
        
        else {
            ps.setNull(6, java.sql.Types.BLOB); 
        }
        
      
        ps.setString(7, prevProduct.getPid());

        int count = ps.executeUpdate();
        if (count == 1) {
            status = "Product Updated Successfully with ID - " + prevProduct.getPid();
        }

    } catch (SQLException ex) {
        System.err.println("Error updating product: " + ex.getMessage());
        ex.printStackTrace();
    }
     
    return status;
}

 
    @Override
public String updateProductPrice(String prodId, Double updatedPrice) {
    String status = "Product price update failed!";
    
    String query = "UPDATE products SET pprice = ? WHERE pid = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        // Set the new price and product ID
        ps.setDouble(1, updatedPrice);
        ps.setString(2, prodId);
        
        // Execute the update
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 1) {
            status = "Product price updated successfully for product ID: " + prodId;
        }
    } catch (SQLException ex) {
        System.err.println("Error updating product price: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return status;
}
@Override
public List<ProductsPojo> getAllProducts() {
    List<ProductsPojo> productList = new ArrayList<>();
    
    String query = "SELECT * FROM products";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        
        // Iterate through the ResultSet and create ProductsPojo objects
        while (rs.next()) {
            ProductsPojo product = new ProductsPojo();
            product.setPid(rs.getString("pid"));
            product.setPname(rs.getString("pname"));
            product.setPtype(rs.getString("ptype"));
            product.setPinfo(rs.getString("pinfo"));
            product.setPprice(rs.getDouble("pprice"));
            product.setPquantity(rs.getInt("pquantity"));
            product.setPimage(rs.getBinaryStream("image"));
            
            // Add the product to the list
            productList.add(product);
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching all products: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return productList;
}




    
  @Override
public List<ProductsPojo> getAllProductsByType(String type) {
    List<ProductsPojo> productList = new ArrayList<>();
    
    String query = "SELECT pid, pname, ptype, pinfo, pprice, pquantity, pimage FROM products WHERE ptype = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        // Set the product type parameter
        ps.setString(1, type);
        
        try (ResultSet rs = ps.executeQuery()) {
            // Iterate through the ResultSet and populate the productList
            while (rs.next()) {
                ProductsPojo product = new ProductsPojo();
                product.setPid(rs.getString("pid"));
                product.setPname(rs.getString("pname"));
                product.setPtype(rs.getString("ptype"));
                product.setPinfo(rs.getString("pinfo"));
                product.setPprice(rs.getDouble("pprice"));
                product.setPquantity(rs.getInt("pquantity"));
                product.setPimage(rs.getBinaryStream("pimage"));
                
                productList.add(product);
            }
        }
    } 
    
    catch (SQLException ex) {
        System.err.println("Error fetching products by"+ex);
        ex.printStackTrace();

    }
    
    return productList;
}
        
        
      
        
     @Override
public List<ProductsPojo> searchAllProducts(String search) {
    List<ProductsPojo> productList = new ArrayList<>();
    
    // SQL query to search products by name, type, or info
    String query = "SELECT pid, pname, ptype, pinfo, pprice, pquantity, pimage FROM products " +
                   "WHERE pname LIKE ? OR ptype LIKE ? OR pinfo LIKE ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        // Set search parameters using wildcard character for LIKE clause
        String searchPattern = "%" + search + "%";
        ps.setString(1, searchPattern);
        ps.setString(2, searchPattern);
        ps.setString(3, searchPattern);
        
        try (ResultSet rs = ps.executeQuery()) {
            // Iterate through ResultSet and populate the productList
            while (rs.next()) {
                ProductsPojo product = new ProductsPojo();
                product.setPid(rs.getString("pid"));
                product.setPname(rs.getString("pname"));
                product.setPtype(rs.getString("ptype"));
                product.setPinfo(rs.getString("pinfo"));
                product.setPprice(rs.getDouble("pprice"));
                product.setPquantity(rs.getInt("pquantity"));
                product.setPimage(rs.getBinaryStream("Pimage"));
                
                productList.add(product);
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error searching products: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return productList;
}



  @Override
public ProductsPojo getProductsDetails(String prodId) {
    ProductsPojo product = null;
    
    String query = "SELECT pid, pname, ptype, pinfo, pprice, pquantity, pimage FROM products WHERE pid = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setString(1, prodId);
        
        try (ResultSet rs = ps.executeQuery()) {
            // If a product is found, create and populate the ProductsPojo object
            if (rs.next()) {
                product = new ProductsPojo();
                product.setPid(rs.getString("pid"));
                product.setPname(rs.getString("pname"));
                product.setPtype(rs.getString("ptype"));
                product.setPinfo(rs.getString("pinfo"));
                product.setPprice(rs.getDouble("pprice"));
                product.setPquantity(rs.getInt("pquantity"));
                product.setPimage(rs.getBinaryStream("pimage"));
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching product details: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return product;
}

  @Override
public int getProductQuantity(String prodId) {
    int quantity = 0;
    
    String query = "SELECT pquantity FROM products WHERE pid = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setString(1, prodId);
        
        try (ResultSet rs = ps.executeQuery()) {
            // If a product is found, get the quantity
            if (rs.next()) {
                quantity = rs.getInt("pquantity");
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching product quantity: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return quantity;
}
  @Override
public String updateProductWithoutImage(String prevProductId, ProductsPojo updatedProduct) {
    String status = "Product Update Failed!";
    
    if (prevProductId == null || updatedProduct == null) {
        return "Invalid Product ID or Product Data!";
    }

    String query = "UPDATE products SET pname = ?, ptype = ?, pinfo = ?, pprice = ?, pquantity = ? WHERE pid = ?";

    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        // Set parameters for the updated product details
        ps.setString(1, updatedProduct.getPname());
        ps.setString(2, updatedProduct.getPtype());
        ps.setString(3, updatedProduct.getPinfo());
        ps.setDouble(4, updatedProduct.getPprice());
        ps.setInt(5, updatedProduct.getPquantity());
        ps.setString(6, prevProductId);

        // Execute update query
        int count = ps.executeUpdate();
        if (count == 1) {
            status = "Product Updated Successfully for Product ID - " + prevProductId;
        }

    } catch (SQLException ex) {
        System.err.println("Error updating product without image: " + ex.getMessage());
        ex.printStackTrace();
    }

    return status;

}

@Override
public double getProductPrice(String prodId) {
    double price = 0.0;
    
    String query = "SELECT pprice FROM products WHERE pid = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setString(1, prodId);
        
        try (ResultSet rs = ps.executeQuery()) {
            // If a product is found, get the price
            if (rs.next()) {
                price = rs.getDouble("pprice");
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching product price: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return price;
}





@Override
public Boolean sellNProduct(String prodId, int n) {
    Boolean isSold = false;
    
    String queryCheck = "SELECT pquantity FROM products WHERE pid = ?";
    String queryUpdate = "UPDATE products SET pquantity = pquantity - ? WHERE pid = ? AND pquantity >= ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement psCheck = conn.prepareStatement(queryCheck);
         PreparedStatement psUpdate = conn.prepareStatement(queryUpdate)) {
        
        // Check if the product has enough quantity to sell
        psCheck.setString(1, prodId);
        
        try (ResultSet rs = psCheck.executeQuery()) {
            if (rs.next()) {
                int currentQuantity = rs.getInt("pquantity");
                
                // If there's enough quantity, update it
                if (currentQuantity >= n) {
                    psUpdate.setInt(1, n);
                    psUpdate.setString(2, prodId);
                    psUpdate.setInt(3, n);
                    
                    int rowsAffected = psUpdate.executeUpdate();
                    if (rowsAffected == 1) {
                        isSold = true;  // Sale successful
                    }
                }
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error selling product: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return isSold;
}


@Override
public List<String> getAllProductsType() {
    List<String> productTypes = new ArrayList<>();
    
    String query = "SELECT DISTINCT ptype FROM products";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        
        // Iterate through ResultSet and add distinct product types to the list
        while (rs.next()) {
            productTypes.add(rs.getString("ptype"));
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching product types: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return productTypes;
}
@Override
public byte[] getImage(String prodId) {
    byte[] image = null;
    
    String query = "SELECT pimage FROM products WHERE pid = ?";
    
    try (Connection conn = DBUtil.provideConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setString(1, prodId);
        
        try (ResultSet rs = ps.executeQuery()) {
            // If a product image is found, retrieve it as a byte array
            if (rs.next()) {
                image = rs.getBytes("pimage");
            }
        }
    } catch (SQLException ex) {
        System.err.println("Error fetching product image: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return image;
}




}

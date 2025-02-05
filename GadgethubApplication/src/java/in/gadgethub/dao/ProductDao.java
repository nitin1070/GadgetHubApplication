/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.dao;

import in.gadgethub.pojo.ProductsPojo;
import java.util.List;

/**
 *
 * @author hp4ce
 */
public interface ProductDao {
    
    public String addProduct(ProductsPojo product);
    public String updateProduct(ProductsPojo prevProduct,ProductsPojo updatedProduct);
    public String updateProductPrice(String prodId,Double updatedPrice);
    public List<ProductsPojo>getAllProducts();
    public List<ProductsPojo>getAllProductsByType(String type);
    public List<ProductsPojo>searchAllProducts(String search);
    public ProductsPojo getProductsDetails(String prodId);
    public int getProductQuantity(String prodId);
    public String updateProductWithoutImage(String prevProductId,ProductsPojo udpatedProduct);
    public double getProductPrice(String prodId);
    public Boolean sellNProduct(String prodId,int n);
    public List<String>getAllProductsType();
    public byte[]getImage(String prodId);
    public String removeProduct(String prodId);
    
    
    
    
    
    
    
    
    
    
    
    
    
}

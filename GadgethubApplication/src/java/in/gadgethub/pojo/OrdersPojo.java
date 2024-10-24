/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.pojo;

/**
 *
 * @author hp4ce
 */
public class OrdersPojo {

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getShipped() {
        return shipped;
    }

    public void setShipped(int shipped) {
        this.shipped = shipped;
    }

    public OrdersPojo(String orderid, String productid, int quantity, Double amount, int shipped) {
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
        this.amount = amount;
        this.shipped = shipped;
    }

    public OrdersPojo() {
    }
    
    private String orderid;
    private String productid;
    private int quantity;
    private Double amount;
    private int shipped;
    
}

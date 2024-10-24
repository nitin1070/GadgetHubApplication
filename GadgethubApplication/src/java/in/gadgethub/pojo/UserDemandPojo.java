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
public class UserDemandPojo {

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
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

    public UserDemandPojo(String useremail, String productid, int quantity) {
        this.useremail = useremail;
        this.productid = productid;
        this.quantity = quantity;
    }

    public UserDemandPojo() {
    }
    
    private String useremail;
    private String productid;
    private int quantity;
}

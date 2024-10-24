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
public class UserPojo {

    public UserPojo(String useremail, String username, String usermobile, String useraddress, String userpassoword, int userpincode) {
        this.useremail = useremail;
        this.username = username;
        this.usermobile = usermobile;
        this.useraddress = useraddress;
        this.userpassoword = userpassoword;
        this.userpincode = userpincode;
    }

    public UserPojo() {
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserpassoword() {
        return userpassoword;
    }

    public void setUserpassoword(String userpassoword) {
        this.userpassoword = userpassoword;
    }

    public int getUserpincode() {
        return userpincode;
    }

    public void setUserpincode(int userpincode) {
        this.userpincode = userpincode;
    }
    
    private String useremail;
    private String username;
    private String usermobile;
    private String useraddress;
    private String userpassoword;
    private int userpincode;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.pojo;

import java.io.InputStream;


/**
 *
 * @author hp4ce
 */
public class ProductsPojo {

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public InputStream getPimage() {
        return pimage;
    }

    public void setPimage(InputStream pimage) {
        this.pimage = pimage;
    }

 

    public ProductsPojo() {
    }
    private  String pid;
    private String pname;
    private String ptype;
    private String pinfo;
    private Double pprice;
    private int pquantity;
    private InputStream pimage;
    
    
}

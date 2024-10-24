/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.pojo;

import java.sql.Date;

/**
 *
 * @author hp4ce
 */
public class TransactionPojo {

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionPojo(String useremail, String transactionid, Date transactionDate, Double amount) {
        this.useremail = useremail;
        this.transactionid = transactionid;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public TransactionPojo() {
    }
    private String useremail;
    private String transactionid;
    private Date transactionDate;
    private Double amount;
    
    
    
}

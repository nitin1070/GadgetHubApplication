/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.dao;

import in.gadgethub.pojo.DemandPojo;
import java.util.List;

/**
 *
 * @author hp4ce
 */
public interface DemandDao {
    public Boolean addProduct(DemandPojo demandpojo);
    public Boolean removeProduct(String userId,String prodId);
    public List<DemandPojo>haveDemanded(String prodId);
    
}

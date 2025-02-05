/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.dao.impl;

import in.gadgethub.dao.DemandDao;
import in.gadgethub.pojo.DemandPojo;
import java.util.List;

/**
 *
 * @author hp4ce
 */
public class DemandDaoImpl implements  DemandDao{

    @Override
    public Boolean addProduct(DemandPojo demandpojo) {
        
        
        
    }

    @Override
    public Boolean removeProduct(String userId, String prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DemandPojo> haveDemanded(String prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

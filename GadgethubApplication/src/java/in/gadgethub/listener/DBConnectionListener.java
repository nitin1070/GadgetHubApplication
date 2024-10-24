/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.listener;

import in.gadgethub.utility.DBUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 *
 * @author hp4ce
 */
public class DBConnectionListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext obj = sce.getServletContext();
         String dbUrl = obj.getInitParameter("url");
         String dbUserName = obj.getInitParameter("username");
         String dbPassword = obj.getInitParameter("password");
        
         DBUtil.openConnection(dbUrl, dbUserName, dbPassword);
         
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}

package code.java.servlet;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
 

public class ContextListener implements ServletContextListener {
	 private static final String ATTRIBUTE_NAME = "config";
	    private Properties config = new Properties();
 
    /**
     * Initialize log4j when the application is being started
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // initialize log4j here
        ServletContext context = event.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
        System.out.println(fullPath);
         
        PropertyConfigurator.configure(fullPath);
//        String authentication = context.getInitParameter("authentication-information");
//        String fullPathAuthentication = context.getRealPath("") + File.separator + authentication;
//       
        try {
        	 
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("authentication2.properties"));
           
        } catch (Exception e) {
        	System.out.println("File Upload Error");
             
        }
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
        event.getServletContext().setAttribute("productList", new LinkedHashMap());
         
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }  
    
    public static ContextListener getInstance(ServletContext context) {
        return (ContextListener) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
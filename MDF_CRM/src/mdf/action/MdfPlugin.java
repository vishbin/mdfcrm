/*
 * 
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mdf.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 * @author 
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MdfPlugin implements PlugIn {

    private static Logger log;

    public void init(ActionServlet servlet, ModuleConfig moduleConfig) throws ServletException {
        initLog4J(servlet);
        initDAO(servlet);
        initContext(servlet.getServletConfig().getServletContext());
        if (log.isDebugEnabled()) {
            log.debug("MDFPlugin initialization  Successfully Completed*******************************");
        }
    }

    private void initLog4J(ActionServlet servlet) {
        // Required for Log4J configuration
        String webAppRoot = servlet.getServletContext().getRealPath("/");
        String log4jProps = servlet.getInitParameter("log4j_properties");
        PropertyConfigurator.configure(webAppRoot + log4jProps);
        MdfPlugin.log = Logger.getLogger(MdfPlugin.class);
        if (log.isDebugEnabled()) {
            log.debug("Successfully log file is created ..............");
        }
    }

    private void initDAO(ActionServlet servlet) throws ServletException {
    	
    //init DAO 
    }

    private void initContext(ServletContext context) {
        
    //cache all the db records 	
    	
     }
   

    /* (non-Javadoc)
     * @see org.apache.struts.action.PlugIn#destroy()
     */
    public void destroy() {
    // TODO Auto-generated method stub

    }

}

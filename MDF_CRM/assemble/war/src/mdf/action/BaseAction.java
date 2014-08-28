package mdf.action;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;

public class BaseAction extends Action {
	
	
	
	protected static Logger log = Logger.getLogger(BaseAction.class);
	
	
	
	
	
	
	/*protected static final Category log = Category.getInstance(BaseAction.class);
	protected final String LOG_PROPERTIES_FILE = "c:\\log4j.properties";
	public BaseAction() {
		initializeLogger();
	}
	
	private void initializeLogger() {
	    Properties logProperties = new Properties();
	    System.out.println("inside initializeLogger");
	    try {
	    	logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
	    	//properties in the classpath
	        //URL url = ClassLoader.getSystemResource(LOG_PROPERTIES_FILE);
	        //logProperties.load(url.openStream());
	    	
	        PropertyConfigurator.configure(logProperties);
	        log.info("Logging initialized.");
	    } catch(IOException ex) {
	    	System.out.println("io exception while initialising logger" + ex);
	    	log.error("io exception while initialising logger" + ex);
	      throw new RuntimeException("Unable to load logging property " + LOG_PROPERTIES_FILE + ex);
	    } catch (Exception ex) {
	    	System.out.println("unknown exception while initialising logger:" +ex);
	    	log.error("unknown exception while initialising logger:" +ex);
	    }
	}*/
}

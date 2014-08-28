/**
 * Title :         AllcorpConstants
 * Description :    
 *                  
 * Copyright :      Copyright (c) 2003-2006
 * Company :        Allstate Insurance
 *
 * Revision History
 * ----------------
 *
 * Date			Author				Description    
 * ------------  ----------------	---------------------------------------------------------
 * Oct 13, 2003	 bkunn				Initial Creation  
 * Nov 17, 2003  Brian Chien		Added Configuration Reader Service constants
 * Nov 19, 2003  Wan Yee Reinherz   added logging constants (12000 series)
 * Dec 05, 2003	 bkunn				added constants for XMLHelper.Helper constants starts from 17000
 * Dec 05, 2003  Wan Yee Reinherz   added constants for DBAppender
 * Dec 16, 2003  Wan Yee Reinherz   added constant for incident locator
 * Dec 18, 2003  Kurt Knutson       added constants for PooledPowerServer
 * Jan 28, 2004  Wan Yee Reinherz   added constant for Instrumentation Appender
 * Jan 29, 2004  golea			    added constant for UuidDispenser
 * Jan 29, 2004  golea				added constants for ModelObjects
 * Jan 29, 2004  Wan Yee Reinherz   added constants for SBAppender
 * Feb 04, 2004  Brian Chien		added constant for Transaction Database JNDI
 * Feb 04, 2004  Venkatesham Gadey  Added constant for Renderer Exceptions
 * Feb 26, 2004  Kurt Knutson       Added constant for Server-specific config file
 * Feb 27, 2004  Kurt Knutson       Added constant for Powerserver server name
 * Mar 02, 2004  Wan Yee Reinherz   Moved AllcorpThrowable datepattern here.
 * Apr 07, 2004  jwad7              Created new XMLHelper messages.
 * Apr 16, 2004  Wan Yee Reinherz   Added constant for MessageReader
 * Apr 23, 2004  Wan Yee Reinherz   remove error codes
 * Apr 27, 2004  Wan Yee Reinherz   Put static data & sessionservice error codes 
 *                                  back.  This is temporary until The codes
 *                                  are placed in the application messages file.
 * Jun 18, 2004  Tony Liu           added constants for MESSAGE_NO_ERROR_TEXT 
 *                                  and MESSAGE_NO_ERROR_CODE. 
 * Jun 19, 2004 Wan Yee Reinherz    Added Message Time to Live Constant    
 * Sep 07, 2004 AK                  Added LOG4J_DEFAULT_INIT_OVERRIDE_PROPERTY_NAME 
 * Oct  6, 2004  aliu7              Added MESSAGE_RESOURCE_SCHEMA_PATH and 
 *                                  MESSAGE_SCHEMA_PATH 
 * Oct  8, 2004  wrein	            Added user home system property
 * Oct 19, 2004  VGadey             Rearranged constants - moved constants from other
 *                                  classes to this class.
 * Dec  2, 2004  wrein              Removed obsolete codes.  Left some codes for 
 *                                  compatibility purpose. 
 * Feb 18, 2005  aliu7              Added 2 codes for configuration framework.
 * Feb 23, 2005  jbaae              Added SERVER_TYPE_SYSTEM_PROPERTY_KEY, READER_INCLUDE,
 *                                  and READER_INCLUDE_NAME
 * Feb 28, 2005  wrein              Deprecated static data, session service and powerserver
 *                                  constants.
 * Oct  3, 2005  jbaae              Removed deprecated fields
 * Aug 31, 2006  jbaae              Added TIBCO_PROCESS_DEFINITION_ID_PROPERTY_KEY and
 *                                        TIBCO_PROCESS_DEFINITION_ID_JMS_KEY
 */
package mdf.utils;

/*======================================================================*/
/* CLASS:       AllcorpConstants                                         */
/**
 * This class represents the constants that will be used within the 
 * infrastructure
 */
public interface AllcorpConstants {
	/*==================================================================*/
	/*===========================            ===========================*/
	/*=========================== Attributes ===========================*/
	/*===========================            ===========================*/
	/*==================================================================*/

	/*==============================================================*/
	/* Constants                                                    */
	/*==============================================================*/

	/*==============================================================*/
	/* ATTRIBUTE:  CONFIGURATION_FILE_PREFIX                        */
	/*                                                              */
	/**
	 * System property key for configuration file prefix. If the user 
	 * desires to customize configuration file name and not use the 
	 * default configuration file, the user will set a System property 
	 * with this key.
	 */
	public static final String CONFIGURATION_FILE_PREFIX =
		"CONFIGURATION_FILE_PREFIX";

	/*==============================================================*/
	/* ATTRIBUTE:  CONFIGURATION_WRAPPER                            */
	/*                                                              */
	/**
	 * System property key for configuration wrapper class. If the 
	 * user desires to customize implementation of AllcorpConfigurable 
	 * and not use the default implementation, the user will set a 
	 * System property with this key.
	 */
	public static final String CONFIGURATION_WRAPPER = "CONFIGURATION_WRAPPER";

	/*==============================================================*/
	/* ATTRIBUTE:  EXCEPTION_DATE_PATTERN                           */
	/*                                                              */
	/**
	 * The date pattern that will be used to format the date object
	 */
	public static final String EXCEPTION_DATE_PATTERN = "yyyy.MM.dd-HH:mm:ss z";

	/*==============================================================*/
	/* ATTRIBUTE:  MESSAGE_RESOURCE_SCHEMA_PATH                     */
	/*                                                              */
	/**
	 * The constant for message resource schema file
	 */
	public static final String MESSAGE_RESOURCE_SCHEMA_PATH =
		"MESSAGE_RESOURCE_SCHEMA_PATH";

	/*==============================================================*/
	/* ATTRIBUTE:  MESSAGE_SCHEMA_PATH                              */
	/*                                                              */
	/**
	 * The constant for message source schema file
	 */
	public static final String MESSAGE_SCHEMA_PATH = "MESSAGE_SCHEMA_PATH";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGING_CONNECTION_FACTORY_EXTENSION   */
	/*                                                      */
	/**
	 * Tag for retrieving the standard connection factory
	 * extension from the configuration file    
	 * <p> 
	 * Constant Value   = <i>CF </i>
	 *</p>
	 */
	public static final String MESSAGING_CONNECTION_FACTORY_EXTENSION =
		"MESSAGING_CONNECTION_FACTORY_EXTENSION";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGING_DEFAULT_RETRIES                */
	/*                                                      */
	/**
	 * Default number of retries if a connection is either dead
	 * or cannot be obtained during the first try    
	 * <p> 
	 * Constant Value   = <i>1 </i>
	 *</p>
	 */
	public static final String MESSAGING_DEFAULT_RETRIES = "1";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGING_DEFAULT_RETRY_DELAY            */
	/*                                                      */
	/**
	 * Delay in milliseconds before each retry. The delay is
	 * compounded by the iteration    
	 * <p> 
	 * Constant Value   = <i>2 </i>
	 *</p>
	 */
	public static final String MESSAGING_DEFAULT_RETRY_DELAY = "2";
	/*======================================================*/
	/* ATTRIBUTE: MESSAGE_TIME_TO_LIVE_IN_MILLISECONDS      */
	/*                                                      */
	/**
	 * Default time to live for messages to be sent to JMS
	 * queue.  This value may be overridden at run time by
	 * applications.
	 * 
	 * <p> 
	 * Constant Value   = <i>10000</i>
	 *</p>
	 *
	 */	
	public static final String MESSAGE_TIME_TO_LIVE_IN_MILLISECONDS = "MESSAGE_TIME_TO_LIVE_IN_MILLISECONDS";	
	
	/*======================================================*/
	/* ATTRIBUTE: NAMING_DEFAULT_CONTEXT_FACTORY_NAME       */
	/*                                                      */
	/**
	 * Default context factory name. Assumes websplere as the
	 * application server providing the initial context factory    
	 * <p> 
	 * Constant Value   = <i>com.ibm.websphere.naming.WsnInitialContextFactory </i>
	 *</p>
	 */
	public static final String NAMING_DEFAULT_CONTEXT_FACTORY_NAME =
		"com.ibm.websphere.naming.WsnInitialContextFactory";
	

	/*======================================================*/
	/* ATTRIBUTE: NAMING_DEFAULT_CONTEXT_FACTORY_NAME       */
	/*                                                      */
	/**
	 * Default lookup url. Provides the server and protocol
	 * the provider uses. Assumes websphere as the default
	 * running on a local machine   
	 * <p> 
	 * Constant Value   = <i>iiop://localhost:2809 </i>
	 *</p>
	 */
	public static final String NAMING_DEFAULT_LOOKUP_URL =
		"iiop://localhost:2809";

	/*======================================================*/
	/* ATTRIBUTE: NAMING_JNDI_FACTORY_TAG                   */
	/*                                                      */
	/**
	 * 
	 * Tag to lookup the JNDI_FACTORY from the configuration
	 * file  
	 * <p> 
	 * Constant Value   = <i>JNDI_FACTORY </i>
	 *</p>
	 */
	public static final String NAMING_JNDI_FACTORY_TAG = "JNDI_FACTORY";

	/*======================================================*/
	/* ATTRIBUTE: NAMING_JNDI_URL_TAG                       */
	/*                                                      */
	/**
	 * 
	 * Tag to lookup the JNDI_URL from the configuration file  
	 * <p> 
	 * Constant Value   = <i>JNDI_PROVIDER_URL </i>
	 *</p>
	 */
	public static final String NAMING_JNDI_URL_TAG = "JNDI_PROVIDER_URL";

	/*======================================================*/
	/* ATTRIBUTE:  LOGGING_LOG_FILE                                 */
	/*                                                      */
	/**
	 * 
	 * Name of the tag that points to the log4J configuration
	 * files.   
	 * 
	 */
	public static final String LOGGING_LOG_FILE = "LOGGING_CONFIG_FILE";

   /*======================================================*/
   /* ATTRIBUTE:  LOGGING_SHOW_CORRELATION_ID              */
   /*                                                      */
   /**
    * 
    * Name of the property tag that indicates whether the
    * correlation ID should be shown in a logging message   
    * 
    */
   public static final String LOGGING_SHOW_CORRELATION_ID = 
      "LOGGING_SHOW_CORRELATION_ID";

   /*======================================================*/
   /* ATTRIBUTE:  LOGGING_SHOW_CLASS_NAME                  */
   /*                                                      */
   /**
    * 
    * Name of the property tag that indicates whether the
    * class name should be shown in a logging message   
    * 
    */
   public static final String LOGGING_SHOW_CLASS_NAME = 
      "LOGGING_SHOW_CLASS_NAME";


	/*======================================================*/
	/* ATTRIBUTE:  DEFAULT_DELIMETER                        */
	/*                                                      */
	/**
	 * The delimiter to use if caller did not pass delimiter.
    * <p/>
	 */
	public static final String READER_DEFAULT_DELIMETER = "=";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGE_RESOURCE_FILE_PATH               */
	/*                                                      */
	/**
	 * The name of the system property that contains the path to
	 * config file that specifies the locations of the message
	 * resource files for each application.
	 */
	public static final String MESSAGE_RESOURCE_FILE_PATH =
		"MESSAGE_RESOURCE_FILE_PATH";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGE_NO_ERROR_TEXT                    */
	/*                                                      */
	/**
	 * The error message for MessageResource processing when the 
	 * MessageResource itself is unavailable.
	 */
	public static final String MESSAGE_NO_ERROR_TEXT =
		"Error message text is unavailable";

	/*======================================================*/
	/* ATTRIBUTE:  MESSAGE_NO_ERROR_CODE                    */
	/*                                                      */
	/**
	 * The error text for MessageResource processing when the 
	 * MessageResource itself is unavailable.
	 */
	public static final String MESSAGE_NO_ERROR_CODE = "99999";

	/*======================================================*/
	/* ATTRIBUTE:  READER_CONFIG_FILE_PROPERTY_NAME         */
	/*                                                      */
	/**
	 * The constant for the base application configuration file name
	 * key value in System.properties.  This value is only used 
	 * if the file /META-INF/config/Allcorp.config.xml is not found.
	 */
	public static final String READER_CONFIG_FILE_PROPERTY_NAME =
		"APPL_CONFIG_FILE";

	/*======================================================*/
	/* ATTRIBUTE:  READER_CONFIG_SERVER_PROPERTY_NAME       */
	/*                                                      */
	/**
	* The constant for the server name key value in 
	* System.properties.  This value, if present, is used to
	* construct the server-specific application configuration 
	* file name. 
	* 
	*/
	public static final String READER_CONFIG_SERVER_PROPERTY_NAME =
		"ALLCORP_CONFIG_SERVER_NAME";

	/*======================================================*/
	/* ATTRIBUTE:  LOG4J_DEFAULT_INIT_OVERRIDE_PROPERTY_NAME*/
	/*                                                      */
	/**
	* The constant for the log4j.defaultInitOverride system property name
	*    
	* 
	*/
	public static final String LOG4J_DEFAULT_INIT_OVERRIDE_PROPERTY_NAME =
				"LOG4J_DEFAULT_INIT_OVERRIDE";
		
	/*======================================================*/
	/* ATTRIBUTE: UNKNOWN_HOST              				*/
	/*                                                      */
	/**
		 * If the host name is unknown this attribute is
		 * used to populate the corresponding output
		 * attribute 
		 * 
	 */	
	public static final String UNKNOWN_HOST ="Unknown Host";
	/*======================================================*/
	/* ATTRIBUTE: UNKNOWN_APP                				*/
	/*                                                      */
	/**
		 * If the app name is unknown this attribute is
		 * used to populate the corresponding output
		 * attribute 
		 * 
	 */	
	public static final String UNKNOWN_APP = "Unknown Application";

	/*======================================================*/
	/* ATTRIBUTE: ERROR_CREATE_ACTION_ERROR_ID				*/
	/*                                                    */
	/**
		 * ID for the message ERROR_CREATE_ACTION_ERROR  
		 * 
		 */
	public final static String ERROR_CREATE_ACTION_ERROR_ID = "16001";
	/*======================================================*/
	/* ATTRIBUTE: ERROR_SIGNON_RS   						*/
	/*                                                    */
	/**
		   * ID for the message ERROR_SIGNON_RS
		   * 
		   */
	
	public final static String ERROR_SIGNON_RS = "16010";

	/*======================================================*/
	/* ATTRIBUTE: XMLHELPER_INVALID_XML				*/
	/*                                                    */
	/**
		* Message to indicate the XML is Invalid XML
		* 
		*/
	public final static String XMLHELPER_INVALID_XML = "Invalid XML";

	/*======================================================*/
	/* ATTRIBUTE: SESSION_SERVICE_PERSIST_DATA_ERROR        */
	/*                                                      */
	/**
	 * The error code indicates error persisting data. 
	 * 
	 */
	public final static String SESSION_SERVICE_PERSIST_DATA_ERROR = "19000";
	
	/*======================================================*/
	/* ATTRIBUTE: DEFAULT_NULL_MESSAGE     				    */
	/*                                                      */
	/**
	 * The message that should be set if the error message
	 * cannot be found in the message file.
	 */
	public final static String DEFAULT_NULL_MESSAGE =
		"Message is not found in the resource file.";
	
    /*======================================================*/
	/* ATTRIBUTE: USER_NAME_SYSTEM_PROPERTY_KEY				*/
	/*                                                      */
	/**
	 * The key for obtaining user name from system property.
	 */
    public static final String USER_NAME_SYSTEM_PROPERTY_KEY = "user.name"; 	
   
   /*======================================================*/
   /* ATTRIBUTE: SERVER_TYPE_SYSTEM_PROPERTY_KEY           */
   /*                                                      */
   /**
    * The key for obtaining application server type from system property.
    */
   public static final String SERVER_TYPE_SYSTEM_PROPERTY_KEY = "application.server.type";   
   
   /*======================================================*/
   /* ATTRIBUTE: TIBCO_PROCESS_DEFINITION_ID_PROPERTY_KEY  */
   /*                                                      */
   /**
    * The key for obtaining the TIBCO process definition ID 
    * from AllcorpProperties.
    * <p/>
    * @since version 3.6.2, 4.0.2
    */
   public static final String TIBCO_PROCESS_DEFINITION_ID_PROPERTY_KEY = "TIBCO_PROCESS_DEFINITION_ID";
   
   /*======================================================*/
   /* ATTRIBUTE: TIBCO_PROCESS_DEFINITION_ID_JMS_KEY       */
   /*                                                      */
   /**
    * The key for setting the TIBCO process definition ID 
    * into the JMS message.
    * <p/>
    * @since version 3.6.2, 4.0.2
    */
   public static final String TIBCO_PROCESS_DEFINITION_ID_JMS_KEY = "ProcessDefinitionID";

}

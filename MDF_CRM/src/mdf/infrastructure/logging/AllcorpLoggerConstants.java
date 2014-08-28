//*======================================================================*/
/**
 * Title :          AllcorpLoggerConstants
 * Description :    AllcorpLoggerConstants has the constants used in 
 *                  AllcorpLogger.
 * Copyright :      Copyright (c) 2004
 * Company :        Allstate Insurance
 *
 * Revision History
 * ----------------
 *
* Date          Author                Description    
 * -----------   ----------------      ---------------------
 * 10/30/2003   Yevgeiny Kelman        Initial Creation
 * 11/01/2003   Venkatesham Gadey      Added messages and new constants
 * 11/10/2003   Venkatesham Gadey      Changed the name to 
 *                                        InstrumentationRendererConstants
 * 12/09/2003   Venkatesham Gadey      Added constants to support
 *                                      the schema changes  
 * 12/15/2003   Venkatesham Gadey      Added schema related comments
 * 03/01/2004   Wan Yee Reinherz       Changed to conform to new schema.
 * 03/10/2004   Wan Yee Reinherz       added instrumentation event constant
 *                                     and logging database format.
 * 05/12/2004	Ranjith Furtado		   Modified the render class name to include the fully
 * 									   qualified name
 * 10/14/2004   wrein/akost            Added column sizes lengths (Short-term solution)
 * 10/19/2004   VGadey                 Added new constants (moved constants from other
 *                                     classes to this interface).
 * 10/21/2004   wrein                  Added level constants.
 * 10/25/2004   wrein/ykelman          Added default String value.
 * 5/23/2005    wrein                  Moved ARM_DATA_COLUMN_LENGTH here from MetricsRenderer
 * 6/07/2005    wrein                  Moved ARM record types from MetricsInfo
 * 09/11/2006   jbaae                  Updates for ManagedSecurity section
 */
/*                                                                      */
/*======================================================================*/
package mdf.infrastructure.logging;

import org.apache.log4j.Level;

/*==========================================================*/
/* INTERFACE:  AllcorpLoggerConstants                       */
/**
 * This interface defines all the constants that are used in
 * the logging framework.
 
 * <p>
 * <b>Notes:</b><p>
 * <p>
 * This class contains constants that
 * are used in instrumentationrenderer are defined in this
 * interface. These constants are used to build the XML
 * schema in the implementation object.
 * <p>
 * <b>XML Schema Description (elements that are considered
 *                         to be primary elements)</b>
 * <p>
 * &lt;ErrorMessageEvent&gt;
 * Error Message that this event generated
 * <p>
 * &lt;EventSourceInstance&gt; 
 * GUID that represents a unique identifier for each event source instance.
 * <p>
 * &lt;EventSourceName&gt;  
 * The Event source, sequence and Schema version  of the generated exception
 * <p>
 * &lt;WindowsSecurity&gt;  
 * Security information of the exception Account name and process account
 * <p>
 * &lt;TimeStamp&gt;
 * Timestamp of the exception
 * <p>
 * &lt;AppDomainName&gt;
 * Application domain that this exception or error belongs to
 * <p>
 * &lt;MachineName&gt;
 * The servername/workstation name that Generated this exception/error
 * <p>
 * &lt;RootRequestName&gt;
 * Root (top-level) request name within which this the event was raised.
 * <p>
 * &lt;RootRequestInstance&gt;
 * Root request name (business component)) within which this the event was raised.
 * <p>
 * &lt;RequestInstance&gt;
 * Current request instance (unique GUID) within which the event was raised.
 * <p>
 * &lt;EventLogEntryTypeId&gt;
 * Id that is associated with the event log entry
 * <p>
 * &lt;ApplicationName&gt;          
 * Name of the application
 * <p>
 * &lt;StackTrace&gt;
 * Stack trace of the error that was encountered
 * <p>
 * &lt;ErrorCode&gt;
 * Error code associated with the error
 * <p>
 * &lt;Severity&gt;
 * Severity of the Error, critical nature of the error
 * <p>
 * &lt;Message&gt;
 * Message associated with the error, full text message
 * 
 */
/*==========================================================*/
public interface AllcorpLoggerConstants {
	
	
	static final String ERROR_MESSAGE_EVENT = "ErrorMessageEvent";
	static final String EVENT_SOURCE_INSTANCE= "EventSourceInstance";
	static final String EVENT_SOURCE_NAME = "EventSourceName";
	static final String EVENT_SEQUENCE_NUMBER ="EventSequenceNumber";
	static final String EVENT_SCHEMA_VERSION ="EventSchemaVersion";
	static final String OS_SECURITY ="OSSecurity";
	static final String WINDOWS_SECURITY ="WindowsSecurity";
	static final String PROCESS_ACCOUNT_NAME="ProcessAccountName";
	static final String IDENTITY_NAME ="IdentityName";
	static final String CURRENT_ACCOUNT_NAME="CurrentAccountName";
	static final String MANAGED_SECURITY = "ManagedSecurity";
	static final String AUTHENTICATION_TYPE="AuthenticationType";
	static final String IS_AUTHENTICATED ="IsAuthenticated";
	static final String TIME_STAMP = "TimeStamp";
	static final String APP_DOMAIN_NAME="AppDomainName";
	static final String MACHINE_NAME = "MachineName";
	static final String ROOT_REQUEST_NAME = "RootRequestName";
	static final String ROOT_REQUEST_INSTANCE ="RootRequestInstance";
	static final String REQUEST_INSTANCE = "RequestInstance";
	static final String CURRENT_REQUEST_NAME = "RequestName";
	static final String REQUEST_SEQUENCE_NUMBER = "RequestSequenceNumber";
	static final String APPLICATION_NAME = "ApplicationName";
	static final String EVENT_LOG_ENTRY_TYPE_ID = "EventLogEntryTypeID";
	static final String INCIDENT_LOCATOR = "IncidentLocator";
	static final String PROCESS_ID = "ProcessID";
	static final String PROCESS_NAME = "ProcessName";
	static final String THREAD_NAME = "ThreadName";
	static final String STACK_TRACE = "StackTrace";
	static final String ERROR_CODE ="ErrorCode";
	static final String SEVERITY = "Severity";
	static final String DUMMY_FIELD = " ";
	static final String EXCEPTION_MESSAGE = "Message";
	
	// XML START AND END TAGS
   static final String MANAGED_SECURITY_START_TAG = "<ManagedSecurity>";
   static final String MANAGED_SECURITY_END_TAG =   "</ManagedSecurity>";
   static final String IDENTITY_NAME_START_TAG = "<IdentityName>";
   static final String IDENTITY_NAME_END_TAG =   "</IdentityName>";
   static final String AUTHENTICATION_TYPE_START_TAG = "<AuthenticationType>";
   static final String AUTHENTICATION_TYPE_END_TAG =   "</AuthenticationType>";
   static final String IS_AUTHENTICATED_START_TAG = "<IsAuthenticated>";
   static final String IS_AUTHENTICATED_END_TAG =   "</IsAuthenticated>";
	static final String TIMESTAMP_START_TAG = "<TimeStamp>";
	static final String TIMESTAMP_END_TAG =   "</TimeStamp>";
	static final String APPDOMAIN_START_TAG = "<AppDomainName>";
	static final String APPDOMAIN_END_TAG = "</AppDomainName>";
	static final String MACHINE_NAME_START_TAG= "<MachineName>";
	static final String MACHINE_NAME_END_TAG="</MachineName>";
	static final String ROOTREQUEST_NAME_START_TAG="<RootRequestName>";
	static final String ROOTREQUEST_NAME_END_TAG="</RootRequestName>";
	static final String ROOTREQUEST_INSTANCE_START_TAG="<RootRequestInstance>";
	static final String ROOTREQUEST_INSTANCE_END_TAG="</RootRequestInstance>";
	static final String REQUEST_INSTANCE_START_TAG="<RequestInstance>";
	static final String REQUEST_INSTANCE_END_TAG="</RequestInstance>";
	static final String REQUEST_NAME_START_TAG="<RequestName>";
	static final String REQUEST_NAME_END_TAG="</RequestName>";
	static final String REQUEST_SEQUENCE_NUMBER_START_TAG="<RequestSequenceNumber>";
	static final String REQUEST_SEQUENCE_NUMBER_END_TAG="</RequestSequenceNumber>";
	static final String APPLICATION_NAME_START_TAG="<ApplicationName>";
	static final String APPLICATION_NAME_END_TAG="</ApplicationName>";
	static final String EVENTLOG_ENTRY_TYPEID_START_TAG="<EventLogEntryTypeID>";
	static final String EVENTLOG_ENTRY_TYPEID_END_TAG="</EventLogEntryTypeID>";
	static final String INCIDENT_LOCATOR_START_TAG="<IncidentLocator>";
	static final String INCIDENT_LOCATOR_END_TAG="</IncidentLocator>";
	static final String PROCESS_ID_START_TAG="<ProcessID>";
	static final String PROCESS_ID_END_TAG="</ProcessID>";
	static final String PROCESS_NAME_START_TAG="<ProcessName>";
	static final String PROCESS_NAME_END_TAG="</ProcessName>";
    static final String THREAD_NAME_START_TAG="<ThreadName>";
	static final String THREAD_NAME_END_TAG="</ThreadName>";
	static final String STACK_TRACE_START_TAG="<StackTrace>";
	static final String STACK_TRACE_END_TAG="</StackTrace>";
	static final String ERROR_CODE_START_TAG="<ErrorCode>";
	static final String ERROR_CODE_END_TAG="</ErrorCode>";
	static final String SEVERITY_START_TAG="<Severity>";
	static final String SEVERITY_END_TAG="</Severity>";
	static final String MESSAGE_START_TAG="<Message>Correlation ID=";
	static final String SEMI_COLON_TAG=";";
	static final String MESSAGE_END_TAG="</Message>";
	static final String ERROR_MESSAGE_EVENT_END_TAG="</ErrorMessageEvent>";
	
	// messages
	static final String TIMESTAMP_MESSAGE = "Instrumentation -TimeStamp is a required field";
	static final String APPDOMAIN_MESSAGE = "Instrumentation -AppDomainName is a required field";
	static final String MACHINENAME_MESSAGE = "Instrumentation -MachineName is a required field";
	static final String ROOTREQUEST_NAME_MESSAGE ="Instrumentation -RootRequestName is a required field";
	static final String REQUESTINSTANCE_MESSAGE = "Instrumentation -RequestInstance is a required field";
	static final String CURRENT_REQUESTNAME_MESSAGE = "Instrumentation-RequestName is a required field";
	static final String STACKTRACE_MESSAGE ="Instrumentation-StackTrace is a required field";
	static final String ERRORCODE_MESSAGE = "Instrumentation-ErrorCode is a required field";
	static final String SEVERITY_MESSAGE = "Instrumentation-ErrorCode is a required field";
	static final String EXCEPTION_MESSAGE_DESCRIPTION="Instrumentation-Message is a required field";
	static final String APPLICATION_NAME_MESSAGE = "Instrumentation -Application Name is a required field";
	static final String RENDERER_GENERAL_EXCEPTION="Instrumentation - Renderer General Exception";
	static final String RENDERER_BUSINESS_FUNCTION = "Instrumentation Renderer XML Message Transformation";
	static final String RENDERER_CLASS_NAME= "com.allcorp.infrastructure.logging.InstrumentationRenderer";
	static final String RENDERER_METHOD =  "Instrumentation Renderer - doRender()";
	
	// event types that are from the event_types table in the logging database.
	// only the ones that are being used in the framework are here.
	static final int INSTRUMENTATION_ERROR_MESSAGE_EVENT = 11;
	static final String DB_DATE_FORMAT = "yyyyMMdd HH:mm:ss";   
	static final String UNKNOWN_USER = "Unknown User";   
	static final String UNKNOWN_ROOT_REQUEST = "Unknown root request";
	static final String UNKNOWN_REQUEST = "Unknown request";
	//static final String UNKNOWN_APP = "Unknown Application";
	static final String UNKNOWN_INC_LOCATOR = "Unknown";
	//static final String UNKNOWN_HOST ="Unknown Host";
	// short-term: database varchar column sizes
	static final int ROOT_REQUEST_ID_LEN = 36;
	static final int ROOT_REQUEST_NM_LEN = 255;
	static final int CURRENT_REQUEST_NM_LEN = 255;
	static final int APPL_NM_LEN = 60;
	static final int MACHINE_NM_LEN = 60;
	static final int INCIDENT_LOCATOR_LEN = 7;
	static final int USER_ID_LEN = 20;
	static final int ARM_DATA_COLUMN_LENGTH = 42;
	static final int ARM_APPL_DATA_COLUMN_LENGTH = 1280;
	/*
	 *  These are ARM record type constants
	 */
	static final String ARM_CLIENT_RECORD_TYPE = "1";
	static final String ARM_NETWORK_RECORD_TYPE = "2";
	static final String ARM_SERVER_RECORD_TYPE = "3";

	/*======================================================*/
	/* ATTRIBUTE:  EMPTY_STRING                             */
	/*                                                      */
	/**
	  * default string value
	*/
	static final String EMPTY_STRING = "null string.";
	/*======================================================*/
	/* ATTRIBUTE:  ALL                                      */
	/*                                                      */
	/**
		* all level event
	*/
	static final String ALL = Level.ALL.toString();
	/*======================================================*/
	/* ATTRIBUTE:  DEBUG                                    */
	/*                                                      */
	/**
		* debug level event
	*/
	static final String DEBUG = Level.DEBUG.toString();
	/*======================================================*/
	/* ATTRIBUTE:  ERROR                                    */
	/*                                                      */
	/**
		* error level event
	*/
	static final String ERROR = Level.ERROR.toString();
	/*======================================================*/
	/* ATTRIBUTE:  INFO                                    */
	/*                                                      */
	/**
		* informational level event 
	*/
	static final String INFO = Level.INFO.toString();
	/*======================================================*/
	/* ATTRIBUTE:  FATAL                                    */
	/*                                                      */
	/**
		* fatal level 
	*/
	static final String FATAL = Level.FATAL.toString();
	/*======================================================*/
	/* ATTRIBUTE:  WARN                                     */
	/*                                                      */
	/**
		* warning level event
	*/
	static final String WARN = Level.WARN.toString();
	
}

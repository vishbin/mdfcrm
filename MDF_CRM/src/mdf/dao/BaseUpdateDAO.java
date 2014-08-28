package mdf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mdf.action.BaseAction;

import org.apache.log4j.Category;

public class BaseUpdateDAO {
	
	protected static final Category log = Category.getInstance(BaseAction.class);
	protected final String LOG_PROPERTIES_FILE = "c:\\log4j.properties";

	//jdbc:mysql://[hostname][:port]/dbname[?param1=value1][&param2=value2]
	// For godaddy hosting, server=p50mysql37.secureserver.net, user=mydreamflight, password=Mantissa123, dbname=mydreamflight
	// For local hosting, server=, user=root, password=kaushik, dbname=mydreamflight

	//local DB
	//String DBUrl = "jdbc:mysql:///mydreamflight";
	//String DBUser = "root";
	//String DBPassword = "kaushik";

	//Godaddy DB 10.6.166.44
	//String DBUrl = "jdbc:mysql://p50mysql37.secureserver.net/mydreamflight";
	//String DBUrl = "jdbc:mysql://10.6.166.44/mydreamflight";
	//String DBUser = "mydreamflight";
	//String DBPassword = "Mantissa123";
	
	//fms.net
	String DBUrl = "jdbc:mysql://SQL06.FREEMYSQL.NET/mdfdb";
	String DBUser = "kaushik";
	String DBPassword = "kaushik12";
	
	Connection conn = null;
	public void initDB() throws Exception {
		try {
			//create a new instance of the mysql driver
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (Exception Ex) {
			log.info("Unable to Load Driver: " + Ex.toString());
		}
		// get a new connection object 
		conn = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
		// get a new statement object 
	}

	public void closeDB() throws Exception {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString());
			}
		}
	}
}

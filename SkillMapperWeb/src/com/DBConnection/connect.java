package com.DBConnection;

import java.sql.*;  
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class connect {

	

  public Connection con()
{
	  Connection connection = null;
	  String url=null;
	  String database=null;
	  String dbuser=null;
	  String dbpassword=null;
	  String driver=null;
	
	  try {
	  /*  
		Properties prop = new Properties();
		InputStream input = null;

		

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
*/			
			url="jdbc:h2:~/niitdb";  //  prop.getProperty("url");
			//database="niitdb"; //prop.getProperty("database");
			dbuser="sa"; //prop.getProperty("dbuser");
			dbpassword="password";//prop.getProperty("dbpassword");
			driver="org.h2.Driver"; //prop.getProperty("driver");
		
			System.out.println(url);
			// System.out.println(database);
			System.out.println(dbuser);
			System.out.println(dbpassword);
			System.out.println(driver);
			
	//		input.close();
  
	
    	Class.forName(driver);
		connection = DriverManager.getConnection(url,dbuser,dbpassword);
	  
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	 
	  return connection;
		
		
		
}}


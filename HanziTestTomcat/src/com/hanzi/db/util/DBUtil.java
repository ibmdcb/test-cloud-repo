package com.hanzi.db.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getConnection() throws Exception{
		
		Connection connection = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/hanzi");
		connection = ds.getConnection();
		return connection;
	}

	public static Connection getConnectionNonJNDI() throws Exception{
	
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yz","yxz297","John415");  
		return con;
	}
}

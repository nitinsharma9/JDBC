package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {

	static public String driver = "oracle.jdbc.driver.OracleDriver";
	static public String url="jdbc:oracle:thin:@localhost:1521:XE";
	static public String user = "nitin";
	static public String pass="oracle";
	
	static{
		try {
			Class.forName(driver);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		Connection con = DriverManager.getConnection(url,user,pass);
		return con;
	}
	
	public static void closeConnection(Connection con) throws SQLException
	{
		con.close();
	}
	
	public static void closeResultSet(ResultSet rs) throws SQLException
	{
		rs.close();
	}
}
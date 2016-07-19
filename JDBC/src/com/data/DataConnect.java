package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnect{

	public static void main(String[] args) throws SQLException  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","NITIN", "oracle");
		Statement stmt = con.createStatement();
		String query = "create table student(id int ,name varchar(30) , branch varchar(30))";
		stmt.execute(query);		
	}

}

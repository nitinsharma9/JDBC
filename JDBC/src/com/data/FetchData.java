package com.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class FetchData {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try{
			con = Util.getConnection();
			stmt = con.createStatement();
			String query = "select * from student";
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			for(int i = 1 ; i <= col ; i++)
			{
				System.out.print(rsmd.getColumnName(i)+"                ");
			}
			System.out.println();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"                "+rs.getString(2)+"                "+rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

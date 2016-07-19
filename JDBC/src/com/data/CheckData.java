package com.data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class CheckData {

	public static void main(String[] args) throws SQLException , IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		try{
			con = Util.getConnection();
			stmt = con.createStatement();
			File file  = new File("E:\\sql.properties");
			FileReader fr = new FileReader(file);
			Properties pr = new Properties();
			pr.load(fr);
			Set<String> s = pr.stringPropertyNames();
			Iterator<String> it = s.iterator();
			while(it.hasNext())
			{
				String key = it.next();
				String value = pr.getProperty(key);
				stmt.executeUpdate(value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			Util.closeConnection(con);
			stmt.close();
		}
	}

}
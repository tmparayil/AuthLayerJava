package com.oracle.utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection()
	{
		Connection con = null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@indl124088.in.oracle.com:1522/in124088","fusion","fusion");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Connected to in124088");
		return con;
	}

}

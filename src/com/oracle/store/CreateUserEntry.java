package com.oracle.store;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.oracle.utilites.DBConnect;

public class CreateUserEntry {
	
	
	
	@POST
	@Path("/AddEntry")
	@Produces(MediaType.APPLICATION_JSON)
	public void AddEntry(String body)
	{
		String user=null;
		String token=null;
		//Adding GUID and Token to DB
		
		UserSession obj = null;
		try{
			JSONObject jObject  = new JSONObject(body); // json
			JSONObject data = jObject.getJSONObject("data"); // get data object
			System.out.println(jObject);
			System.out.println(data);
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		insertToDB(obj);
	}
	
	private static void insertToDB(Object obj){
		
		UserSession user = (UserSession)obj;
		String userName = user.get_guid();
		String token = user.get_token();
		
		String sql = "insert into GENERIC_USER_TOKEN_STORE (USERID,TOKEN) values (\'"+userName+"\',\'"+token+"\')";
		Connection conn = DBConnect.getConnection();
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Insertion into DB done");		
		
	}
	
	public static void testInsertion(Object obj){
		
		insertToDB(obj);
	}

}

package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn =null;
	public void getDbConnection(String url,String username,String password) throws Throwable {
		try {
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
		}
		
	}
	public void getDbConnection() throws Throwable {
		try {
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		}catch(Exception e) {
		}
		
	}
	
	
	public void closeDbConnection() throws SQLException {
		try {
			conn.close();
		}catch(Exception e) {
			
		}
		
	}
	
	public ResultSet ExecuteSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = conn.createStatement();
		 result = stat.executeQuery(query);
		}catch(Exception e) {
		}
		return result;
	
	}
	
	
	public int excuteNonSelectQuery(String Query) throws SQLException {
		int result=0;
		try {
		Statement stat = conn.createStatement();
		result=stat.executeUpdate(Query);
		}catch(Exception e) {
		}
		
		return result;
		
	}
	
	

}

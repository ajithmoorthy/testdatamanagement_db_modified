package com.atmecs.atmecs_automation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atmecs.atmecs_automation.logreports.LogReporter;


public class DatabaseReader {
	LogReporter log=new LogReporter();
	ResultSet rs; 
	Statement stmt;
	Connection con;
	public void dbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    	String connectionUrl = "jdbc:sqlserver://ATMECSINLT-085\\SQLEXPRESS;database=testdata;integratedSecurity=true;";  
    	con = DriverManager.getConnection(connectionUrl);  
    	log.logReportMessage("connection is estabilished");
	}
	public String[] insertQuery(int size,String footer) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM "+footer;
	    rs = stmt.executeQuery(sql);
	    String[] temparray=new String[size];
	    int count=0;
	    while(rs.next()) {
	     String	testdata=rs.getString("footer").toString();
	     temparray[count]=testdata;
	     count++;
	}
	    return temparray;
	}

}

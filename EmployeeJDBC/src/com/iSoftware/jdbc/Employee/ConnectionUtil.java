package com.iSoftware.jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() {
		//Get the connection
		Connection con = null;
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employerdb", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}

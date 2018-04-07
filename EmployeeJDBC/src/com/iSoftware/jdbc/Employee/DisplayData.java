package com.iSoftware.jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData {
	static Connection con = null;
	static {
		// Get the connection
		 
		try {
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employerdb", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			//Connection con = ConnectionUtil.getConnection();

			// Create the Statement
			Statement statement = con.createStatement();

			// Firing the queries
			ResultSet res = statement.executeQuery("select id,name,age,address,designation,email,salary from employee");
			while (res.next()) {

				int id = res.getInt(1);
				String name = res.getString("name");
				int age=res.getInt(3);
				String address =res.getString("Address");
				String designation = res.getString("Designation");
				String email = res.getString("Email");
				float salary = res.getFloat(7);
				System.out.println("Employee id: " + id+ "|" + " Name: " + name +"|"+ " Age: " +age+"|"+ " Address: " +address+"|"+ " Designation: " +designation+"|"+ " Email: " +email+"|"+ " Salary: " +salary);
			}
			// close connection
			con.close();
			res.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		}
		
	

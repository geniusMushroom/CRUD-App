package com.iSoftware.jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateJDBCTest {
	static PreparedStatement myStmt = null;
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
				
				Scanner scanner = new Scanner(System.in);
		        System.out.println("Insert Employee id to update record: "  );
		        String id1 = scanner.next();
		        System.out.println("Enter New Name:- ");
		        String name1 = scanner.next();
		        System.out.println("Enter New Age:- ");
		        String age1 = scanner.next();
		        System.out.println("Enter New address:- ");
		        String address1 = scanner.next();
		        System.out.println("Enter New designation:- ");
		        String designation1 = scanner.next();
		        System.out.println("Enter New email:- ");
		        String email1 = scanner.next();
		        System.out.println("Enter New Salary:- ");
		        String salary1 = scanner.next(); 

		        //con = connect();

		        String query = "UPDATE employee SET name= ?, age= ?, address= ?, designation=?,email=?, salary=? WHERE id=?;";
	            statement = con.prepareStatement(query);
	            ((PreparedStatement) statement).setString(1, name);
	            ((PreparedStatement) statement).setInt(2, age);
	            ((PreparedStatement) statement).setString(3, address);
	            ((PreparedStatement) statement).setString(4, designation);
	            ((PreparedStatement) statement).setString(5, email);
	            ((PreparedStatement) statement).setFloat(6, salary);
	            int r = statement.executeUpdate(query);
	            if (r > 0) {
	                System.out.println("User was successfully updated.");
	            } else {
	                System.out.println("Failed to update user id " + id);
	            }			
			//close connection
			con.close();
			
			}} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	private static Connection connect() {
		// TODO Auto-generated method stub
		return null;
	}
}

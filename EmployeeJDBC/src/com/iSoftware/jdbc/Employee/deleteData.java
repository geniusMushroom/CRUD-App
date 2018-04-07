package com.iSoftware.jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deleteData {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
	    String input;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/employerdb", "root", "");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select id,name,age,address,designation,email,salary from employee");
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

            Scanner value = new Scanner(System.in);     
            System.out.println("Enter the value to delete:- ");
            input = value.nextLine();
            stmt.executeUpdate("delete from employee where id = "+input );
            System.out.println("Record deleted");
		}
			catch (Exception e) {
			e.printStackTrace();
		
	} finally {
		
		if (con != null) {
			con.close();
		}

	}
	}
}



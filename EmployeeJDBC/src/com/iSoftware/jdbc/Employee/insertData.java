package com.iSoftware.jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertData {

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		PreparedStatement myStmt = null;

		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			System.out.println("None of the fields can be left blank");
			System.out.print("Enter Employee Id(only Numbers): ");
			String id = scanner.nextLine();

			System.out.print("Enter employee full name: ");
			String name = scanner.nextLine();

			System.out.print("Enter employee age(Only Number): ");
			String age = scanner.nextLine();

			System.out.print("Enter employee address: ");
			String address = scanner.nextLine();

			System.out.print("Enter employee Designation: ");
			String designation = scanner.nextLine();

			System.out.print("Enter employee Email: ");
			String email = scanner.nextLine();

			System.out.print("Enter employee Salary(decimal value): ");
			String salary = scanner.nextLine();

			// connection to database

			try {
				// Driver load
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/employerdb", "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Create a statement
			String sql = "insert into employee " + " (id,name,age,address,designation,email,salary)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			myStmt = con.prepareStatement(sql);

			myStmt.setString(1, id);
			myStmt.setString(2, name);
			myStmt.setString(3, age);
			myStmt.setString(4, address);
			myStmt.setString(5, designation);
			myStmt.setString(6, email);
			myStmt.setString(7, salary);

			myStmt.executeUpdate();

			System.out.println("Insert complete to Employee Database.");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myStmt != null) {
				myStmt.close();
			}

			if (con != null) {
				con.close();
			}

			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
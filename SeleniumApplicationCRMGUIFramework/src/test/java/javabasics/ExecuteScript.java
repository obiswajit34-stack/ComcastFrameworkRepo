package javabasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;





public class ExecuteScript {

	public static void main(String[] args) throws Exception {

		//step 1: load/register the database driver
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
		
		
		
		// Step 1: Establish connection with MySQL server
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://49.249.29.4:3307/",
				"root@%",
				"root");

		// Step 2: Create Statement
//		Statement stmt = con.createStatement();
//
//		// Step 3: Create database
//		String createDatabase = "CREATE DATABASE IF NOT EXISTS selenium_ddt";
//
//		boolean result1 = stmt.execute(createDatabase);
//
//		System.out.println("Database created: " + !result1);
//
//		// Step 4: Connect to newly created database
//		con.close();
//
//		con = DriverManager.getConnection(
//				"jdbc:mysql://49.249.29.4:3307/selenium_ddt",
//				"root@%",
//				"root");
//
//		stmt = con.createStatement();
//
//		// Step 5: Create table
//		String createTable = "CREATE TABLE IF NOT EXISTS employee ("
//				+ "emp_id INT PRIMARY KEY, "
//				+ "first_name VARCHAR(50), "
//				+ "last_name VARCHAR(50), "
//				+ "email VARCHAR(100))";
//
//		boolean result2 = stmt.execute(createTable);
//
//		System.out.println("Table created: " + !result2);
//
//		// ------------------------------------------------
//		// Cleanup demonstration
//		// ------------------------------------------------
//
//		// Delete table
//		String dropTable = "DROP TABLE employee";
//
//		boolean result3 = stmt.execute(dropTable);
//
//		System.out.println("Table deleted: " + !result3);
//
//		con.close();
//
//		// Connect again to MySQL server
//		con = DriverManager.getConnection(
//				"jdbc:mysql://49.249.29.4:3307/",
//				"root@%",
//				"root");
//
//		stmt = con.createStatement();
//
//		// Delete database
//		String dropDatabase = "DROP DATABASE selenium_ddt";
//
//		boolean result4 = stmt.execute(dropDatabase);
//
//		System.out.println("Database deleted: " + !result4);
//
//		con.close();
	}
}
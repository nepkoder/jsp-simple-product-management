package com.productmanagement.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection GetConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/productmanagementsystem";
		String user = "root";
		String pass = "sujan";
		
		String driver = "com.mysql.jdbc.Driver";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL,user,pass);
			
			System.out.println("Connection successful");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
		}
		return con;
	}
	
	public static void CloseDatabase(Connection con) {
		
		try {
			if (con!= null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}

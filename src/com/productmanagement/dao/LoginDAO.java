package com.productmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.productmanagement.dbutil.DBUtil;
import com.productmanagement.pojo.LoginInfo;

public class LoginDAO {
	
	public static boolean isValidUser(LoginInfo loginDetails) {
		boolean status = false;
		
		PreparedStatement stmt = null;
		
		try {
			Connection connection = DBUtil.GetConnection();
			stmt = connection.prepareStatement("select *from validuser where username = ? and password = ?");
			stmt.setString(1, loginDetails.getUsername());
			stmt.setString(2, loginDetails.getPassword());
			
			status = stmt.execute();
			
			DBUtil.CloseDatabase(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

}

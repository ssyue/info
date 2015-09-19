package com.register;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.ConnectDatabase;

public class RegisterAction {

	private final static String INSERT_USER_SQL="insert into usertable "
	+ "(username,password)" + "values(?,?)";

	public static boolean add(String username,String password)  {
		Connection connection = ConnectDatabase.getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = (PreparedStatement) connection
					.prepareStatement(INSERT_USER_SQL);
		pStatement.setString(1,username);
		pStatement.setString(2, password);
			//默认注册的用户权限为0
	//		pStatement.setInt(3, 0);
			pStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		add("test1", "123");
	}
	
	
	
	
	
	
	
	
}

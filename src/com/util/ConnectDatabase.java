package com.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnectDatabase {
	public final static String URL = "jdbc:mysql://localhost:3306/info?characterEncoding=utf8&user=root&password=yue642969318";

	private ConnectDatabase() {
	}

	// 获取数据链接
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭数据链接
	public static void closeConnection(java.sql.Connection connection,
			PreparedStatement pStatement) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

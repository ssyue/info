package com.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.ConnectDatabase;
import com.mysql.jdbc.PreparedStatement;

public class ScheduleAction {
	private static final String INSERT_SCHEDULEINFO_SQL = "insert into scheduleInfo "
			+ "(name,phoneNum,IDNum,date)" + "values (?,?,?,?)";

	// 新增数据
	public static boolean add(ScheduleEntity entity) {
		if (entity.getDate() == null)
			return false;
		Connection connection = ConnectDatabase.getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = (PreparedStatement) connection
					.prepareStatement(INSERT_SCHEDULEINFO_SQL);
			pStatement.setString(1, entity.getName());
			pStatement.setString(2, entity.getPhoneNum());
			pStatement.setString(3, entity.getIDNum());
			pStatement.setString(4, entity.getDate());
			pStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDatabase.closeConnection(connection, pStatement);
		}
		return false;

	}

	private static final String SELECT_BY_DATE_SQL = "select  *  from scheduleInfo where date=?";

	// 查询出新增后数据信息
	public static ScheduleEntity getInfo(String date) {
		System.out.println(SELECT_BY_DATE_SQL + date);
		java.sql.Connection connection = ConnectDatabase.getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = (PreparedStatement) connection
					.prepareStatement(SELECT_BY_DATE_SQL);
			pStatement.setString(1, date);
			ResultSet set = pStatement.executeQuery();
			ScheduleEntity entity = new ScheduleEntity();
			while (set.next()) {
				entity.setName(set.getString(1));
				entity.setPhoneNum(set.getString(2));
				entity.setIDNum(set.getString(3));
				entity.setDate(set.getString(4));
				System.out.println(entity.getName() + " " + entity.getDate()
						+ " " + entity.getPhoneNum() + " " + entity.getIDNum());
			}
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDatabase.closeConnection(connection, pStatement);
		}
		return null;
	}

	public static void main(String[] agrs) {
		ScheduleEntity entity = new ScheduleEntity();
		entity.setDate("21");
		entity.setIDNum("123456789");
		entity.setName("yues");
		entity.setPhoneNum("13665516393");
		add(entity);
		ScheduleAction.getInfo("20");
		System.out.println(entity.getName() + " " + entity.getDate() + " "
				+ entity.getPhoneNum() + " " + entity.getIDNum());
	}
}

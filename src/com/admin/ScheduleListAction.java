package com.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.ConnectDatabase;
import com.info.ScheduleEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ScheduleListAction {
	// 默认一页数据数为10
	public final static int PAGE = 10;
	// 查询所有数据
	public final static String SELECT_ALL_SQL = "select * from scheduleInfo";
	// 查询数据条数
	public final static String GET_COUNT_SQL = "select count(*) totalCount from scheduleInfo";
	// 按页查询数据
	public final static String SELECT_BY_PAGE_SQL = "select * from scheduleInfo limit ";

	// 获取所有数据
	public static List<ScheduleEntity> getAll() {
		Connection connection = ConnectDatabase.getConnection();
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection
					.prepareStatement(SELECT_ALL_SQL);
			ResultSet result = statement.executeQuery();
			ArrayList<ScheduleEntity> entityList = new ArrayList<ScheduleEntity>();
			while (result.next()) {
				ScheduleEntity entity = new ScheduleEntity();
				entity.setName(result.getString("name"));
				entity.setPhoneNum(result.getString("phoneNum"));
				entity.setIDNum(result.getString("IDNum"));
				entity.setDate(result.getString("date"));
				entityList.add(entity);
				System.out.println(entity.getName() + " " + entity.getDate()
						+ " " + entity.getPhoneNum() + " " + entity.getIDNum());
			}
			return entityList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDatabase.closeConnection(connection, statement);
		}
		return null;
	}

	// 分页，获取数据库中信息条数
	public static int getCount() {
		int page = 1;
		Connection connection = ConnectDatabase.getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = (PreparedStatement) connection
					.prepareStatement(GET_COUNT_SQL);
			ResultSet set = pStatement.executeQuery();
			while (set.next()) {
				page = set.getInt("totalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDatabase.closeConnection(connection, pStatement);
		}
		// 返回页数
		return (int) Math.round(0.5 + page / PAGE);
	}

	// 按页数获取数据库信息
	// page 是第几页
	public static List<ScheduleEntity> getInfoByPage(int page) {

		Connection connection = ConnectDatabase.getConnection();
		PreparedStatement pStatement = null;
		ResultSet set = null;
		ArrayList<ScheduleEntity> result = new ArrayList<ScheduleEntity>();
		try {
			pStatement = (PreparedStatement) connection
					.prepareStatement(SELECT_BY_PAGE_SQL);
			if (page < 1) {
				page = 1;
			}
			set = pStatement.executeQuery(SELECT_BY_PAGE_SQL + (page - 1)
					* PAGE + "," + PAGE);
			while (set.next()) {
				ScheduleEntity entity = new ScheduleEntity();
				entity.setName(set.getString("name"));
				entity.setDate(set.getString("date"));
				entity.setIDNum(set.getString("IDNum"));
				entity.setPhoneNum(set.getString("phoneNum"));
				System.out.println("id=" + set.getString("id")
						+ entity.getName() + " " + entity.getIDNum() + " "
						+ entity.getPhoneNum() + " " + entity.getDate());
				result.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDatabase.closeConnection(connection, pStatement);
		}
		return result;
	}

	public static void main(String[] args) {
		// 测试
		getInfoByPage(1);
		System.out.println(getCount());
	}

}

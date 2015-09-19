package com.fileUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.ConnectDatabase;

public class InsertToMysql {
//	public final static String INSERT_SQL="insert into testinsert (id,col2,col3)  values (?,?,?)";
	public final static String INSERT_SQL="insert into testinsert (id,col2,col3)  values ";
	public static void insert(File file) throws IOException, SQLException {
		Long start=System.nanoTime();
		Connection c=ConnectDatabase.getConnection();
		PreparedStatement statement=(PreparedStatement) c.prepareStatement(INSERT_SQL);
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String s=null;
		StringBuilder sbBuilder=new StringBuilder(INSERT_SQL);
		while((s=reader.readLine())!=null){
			String[] temp=s.split("\t");
			if (temp.length!=3) {//数据表的列数
				continue;
			}
			sbBuilder.append("(");
			sbBuilder.append("'"+temp[0]+"'"+",");
			sbBuilder.append("'"+temp[1]+"'"+",");
			sbBuilder.append("'"+temp[2]+"'");
			sbBuilder.append("),");
//			i++;
//			statement.setString(1, temp[0]);
//			statement.setString(2, temp[1]);
//			statement.setString(3, temp[2]);
//			statement.addBatch();
//			if (i%100==0) {
//				statement.executeBatch();//575187464725
//			}
		}
		sbBuilder.replace(sbBuilder.length()-1, sbBuilder.length(), ";");
//	System.out.println(sbBuilder.toString());
	Statement statement2=(Statement) c.createStatement();
	statement2.execute(sbBuilder.toString());//341028004
		reader.close();
		c.close();
		Long end=System.nanoTime();
		System.out.println("cost time :"+(end-start));//511360539220 515343286096 575187464725 341028004
	}
	public static void main(String[] args) throws IOException {
		File file =new File("/home/yuess/workspace/eclipse4.2/info/log.txt");
		try {
			InsertToMysql.insert(file);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

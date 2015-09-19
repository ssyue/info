package com.fileUpload;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.fabric.xmlrpc.base.Data;
import com.util.ConnectDatabase;

//@MultipartConfig
//@WebServlet(name="SingleFileUploadServlet",urlPatterns="/singleupload")
public class SingleFileUploadServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("===SingleFileUploadServlet== ");
		
		InputStream in=request.getInputStream();
		InputStreamReader reader=new InputStreamReader(in);
		System.out.println(reader.getEncoding());
		File file=new File("/home/yuess/workspace/eclipse4.2/info/log.txt");
		OutputStreamWriter writer=new OutputStreamWriter(new  BufferedOutputStream(new FileOutputStream(file)));
		System.out.println(writer.getEncoding());
		
		char[]b=new char[1];//值不为1时会出现字符错位
		int n=0;
		while ((n=reader.read(b))!=-1) {
			writer.write(b);
		}
		writer.close();
		reader.close();
		System.out.println("===out==");
//		Part part=request.getPart("file");
//		part.write("/home/yuess/workspace/eclipse4.2/info/log.txt");

		
//		File file =new File("/home/yuess/workspace/eclipse4.2/info/log.txt");
//		try {
//			InsertToMysql.insert(file);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("===SingleFileUploadServlet==");
		}
}

package com.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletController", urlPatterns = { "/scheduleInfo",
		"/addSchedule" })
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,
			HttpServletResponse response) {
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String action = uri.substring(index + 1);
		// 显示预约信息
		if (action.equals("scheduleInfo")) {
			ScheduleEntity entity = ScheduleAction.getInfo(request
					.getParameter("date"));
			request.setAttribute("entity", entity);
		} else if (action.equals("addSchedule")) {
			// 增加预约信息
			if (request.getParameter("name") == null
					&& request.getParameter("date") == null) {
			} else {
				ScheduleEntity entity = new ScheduleEntity();
				entity.setIDNum(request.getParameter("IDNum"));
				entity.setName(request.getParameter("name"));
				entity.setPhoneNum(request.getParameter("phoneNum"));
				entity.setDate(request.getParameter("date"));
				boolean flag = ScheduleAction.add(entity);
				System.out.println(entity.getName() + " " + entity.getDate()
				+ " " + entity.getPhoneNum() + " " + entity.getIDNum());
				PrintWriter writer = null;
				try {
					writer = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 新增成功则返回1到前台
				if (flag) {
					writer.print(1);
				} else {
					writer.print(0);
				}
			}
		}
	}
}

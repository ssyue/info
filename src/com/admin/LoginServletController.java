package com.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.info.ScheduleEntity;
import com.util.Check;

@WebServlet(name = "LoginServletController", urlPatterns = { "/login",
		"/ScheduleList" })
public class LoginServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===service======LoginServletController====");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 验证码
		String inputcode = request.getParameter("code");
		String code = (String) request.getSession().getAttribute("code");
		System.out.println("===inputcode " + inputcode + "==code====" + code);

		int page = 1;
		if (!Check.isNull(request.getParameter("page"))) {
			page = Integer.parseInt(request.getParameter("page"));// 获取页数
		}
		request.setAttribute("page", page);
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/jsp/login.jsp");
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1);
		// 匹配action请求
		// 登陆
		if (("login").equals(action)) {
			// 已登陆则获取数据
			if (Check.isNull(username) || Check.isNull(inputcode)
					||Check.isNull(code)){
				dispatcher.forward(request, response);
				return;
			}
			if (code.equalsIgnoreCase(inputcode)
					&& username.equals(LoginMessage.ADMIN_USERNAME)
					&& password.equals(LoginMessage.ADMIN_PASSWORD)) {

				session.setAttribute("username", username);
				List<ScheduleEntity> list = new ArrayList<ScheduleEntity>();
				// list = ScheduleListAction.getAll();//获取所有信息
				list = ScheduleListAction.getInfoByPage(page);// 获取page页信息
				// // 返回总页数
				// request.setAttribute("pageTotal",
				// ScheduleListAction.getCount());
				request.setAttribute("list", list);
				dispatcher = request
						.getRequestDispatcher("/admin/ScheduleList.jsp");
			} else {
				// 否则跳转到登陆界面
				dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
			}
		} else if (action.equals("ScheduleList")) {
			String name = (String) session.getAttribute("username");
			// 检查是否已登陆
			if (!Check.isNull(name) && name.equals(LoginMessage.ADMIN_USERNAME)) {
				List<ScheduleEntity> list = new ArrayList<ScheduleEntity>();
				// list = ScheduleListAction.getAll();
				list = ScheduleListAction.getInfoByPage(page);// 获取第page页信息
				request.setAttribute("list", list);
				// // 返回总页数
				// request.setAttribute("pageTotal",
				// ScheduleListAction.getCount());
				dispatcher = request
						.getRequestDispatcher("/admin/ScheduleList.jsp");
			} else {
				// 未登录跳转到登陆界面
				dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("===init======LoginServletController====");
	}
}

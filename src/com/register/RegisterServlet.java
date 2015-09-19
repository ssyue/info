package com.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Check;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher=null;
		if (!Check.isNull(username)&&!Check.isNull(password)) {
				RegisterAction.add(username,password);
				dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
		}else{
			dispatcher=request.getRequestDispatcher("/jsp/register.jsp");
		
		}
		dispatcher.forward(request, response);
		
		
	}

}

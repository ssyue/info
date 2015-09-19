package com.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "testServlet", urlPatterns = "/test")
public class Test implements Servlet {
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		String servletName = getServletInfo();
		PrintWriter writer = response.getWriter();
		writer.print("============" + servletName + "============");
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return "hello test";
	}

	public void init(ServletConfig arg0) throws ServletException {

	}

}

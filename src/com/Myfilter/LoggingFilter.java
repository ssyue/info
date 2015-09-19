package com.Myfilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {
	private PrintWriter writer;
	private String prefix;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=====init=====LoggingFilter============");
		prefix=filterConfig.getInitParameter("prefix");
		String logfile=filterConfig.getInitParameter("logfile");
		try {
			writer=new PrintWriter(new File(logfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("=====doFilter=====LoggingFilter============");
		HttpServletRequest r=(HttpServletRequest) request;
		writer.println(new Date()+" "+prefix+r.getRequestURI());
		writer.flush();
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("=====destroy=====LoggingFilter============");
		if (writer!=null) {
			writer.close();
		}
	}

}

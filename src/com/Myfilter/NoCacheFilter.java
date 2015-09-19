package com.Myfilter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class NoCacheFilter
 * 禁止客户端缓存动态资源
 */
public class NoCacheFilter implements Filter {
       
	static Logger logger=Logger.getLogger("NoCacheFilter");
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("======init==========NoCacheFilter====");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("======init======"+"=====NoCacheFilter====");
		HttpServletRequest req=null;
		HttpServletResponse res=null;
		try {
			req=(HttpServletRequest) request;
			res=(HttpServletResponse) response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.setHeader("Expires", "0");
		res.setHeader("Cache-control", "no-cache");
		res.setHeader("Pragma", "no-cache");
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}



}

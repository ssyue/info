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

import org.omg.CORBA.PRIVATE_MEMBER;

import com.util.Check;

/**
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {
       
	static Logger logger=Logger.getLogger("CharacterFilter.class");
	private String encoding;//编码格式
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("======init=====CharacterFilter=====");
		encoding=filterConfig.getInitParameter("encoding");
		if (Check.isNull(encoding)) {
			encoding="UTF-8";
		}
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("======doFilter=====CharacterFilter=====");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding("encoding");
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
	}
    /**
     * @see Filter#Filter()
     */
    public CharacterFilter() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("======destroy=====CharacterFilter=====");
	}

}

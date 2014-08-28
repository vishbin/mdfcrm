package mdf.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogonFilter implements Filter {
	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long before = System.currentTimeMillis();
		if ( ( ((HttpServletRequest)request).getSession() == null || (((HttpServletRequest)request).getSession().getAttribute("user")) == null )
				&& ((HttpServletRequest)request).getRequestURI().indexOf("login")<0 ) {
			((HttpServletResponse)response).sendRedirect("login.jsp");
		} else {
			chain.doFilter(request, response);
		}
		long after = System.currentTimeMillis();
		String name = "";
		if (request instanceof HttpServletRequest) {
			name = ((HttpServletRequest) request).getRequestURI();
		}
		config.getServletContext().log(name + ": " + (after - before) + "ms");
	}
}
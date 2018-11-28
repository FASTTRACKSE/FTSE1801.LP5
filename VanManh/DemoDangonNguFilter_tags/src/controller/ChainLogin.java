package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChainLogin implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest res, ServletResponse rep, FilterChain chainFilter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) res;
		HttpServletResponse response = (HttpServletResponse) rep;
		HttpSession session = request.getSession();	
		String url =request.getServletPath()+"?"+request.getQueryString();
		if (session.getAttribute("userName") != null && session!= null) {
			if (!request.getRequestURI().endsWith("Login.jsp")) {
//				res.getRequestDispatcher(request.getServletPath()).forward(request, response);
				chainFilter.doFilter(request, response);
			}else {
				response.sendRedirect(request.getContextPath());
			}
		} else {
			if (request.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chainFilter.doFilter(request, response);
			} else {
				request.setAttribute("URL", url);
				res.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}

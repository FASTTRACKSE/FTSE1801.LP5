package controller.filter;

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

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String url = req.getRequestURI()+"?" + req.getQueryString();
		if(session!=null&& session.getAttribute("user")!=null) {
			if(!req.getRequestURI().endsWith("Login.jsp")) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath()+"/QLSinhVienServlet");
				
			}
		}else {
			if(req.getRequestURI().matches("css")) {
				chain.doFilter(request, response);
			}else {
				req.setAttribute("url", url);
				req.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
//		boolean loginURI = false;
//		String username = request.getParameter("UserName");
//		String password = request.getParameter("Password");
//		if (username != null && password != null) {
//			if (username.equals("luanngao123") && password.equals("12345")) {
//				session.setAttribute("user", username);
//				loginURI = true;
//
//			} 
//		}
//		if (session.getAttribute("user") != null) {
//			loginURI = true;
//		}
//		if (loginURI) {
//			chain.doFilter(request, response);
//		}else {
//  			request.getRequestDispatcher("Login.jsp").forward(request, response);
//		}
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

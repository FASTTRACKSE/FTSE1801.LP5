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
 * Servlet Filter implementation class CheckLoginFilter
 */
public class CheckLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CheckLoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		String url = req.getRequestURI()+"?" +req.getQueryString();
			if (session != null && session.getAttribute("name") != null) {
				if (!req.getRequestURI().endsWith("LoginServlet")) {
					chain.doFilter(request, response);
				} else {
					res.sendRedirect(req.getContextPath() + "/SinhVienServlet");
				}
			} else {
				req.setAttribute("url", url);
				req.getRequestDispatcher("Login.jsp").forward(req, res);
			}
		
		
		
//		boolean loggedIn = session != null && session.getAttribute("name") != null;
//		boolean loginRequest = req.getRequestURI().equals(loginURI);
//
//		if (loggedIn || loginRequest) {
//			chain.doFilter(request, response);
//		} else {
//			res.sendRedirect(loginURI);
//		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

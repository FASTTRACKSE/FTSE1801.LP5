package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
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
//		String url = req.getRequestURI()+"?" +req.getQueryString();
			if (session != null && session.getAttribute("username") != null) {
				if (!req.getRequestURI().endsWith("/login.xhtml")) {
					chain.doFilter(request, response);
				} else {
					res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
				}
			} else {
//				req.setAttribute("url", url);
				req.getRequestDispatcher("login.xhtml").forward(req, res);
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

package controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class changeLogin
 */
public class changeLogin implements Filter {

    /**
     * Default constructor. 
     */
    public changeLogin() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
//		if(userName != null || password != null) {
//			if(userName.equals("Ola") && password.equals("123")) {
//				session.setAttribute("userName", userName);
//				checkLogin = true;
//			}else {
//				req.setAttribute("dangNhap", "That bai");
//			}
//		}else {
//			if(session.getAttribute("userName") != null) {
//				if(session.getAttribute("userName").equals("Ola")) {
//					checkLogin = true;
//				}
//			}
//		}
//		
//		if(checkLogin) {
//			chain.doFilter(request, response);
//		}else {
//			request.getRequestDispatcher("Login.jsp").forward(request, response);
//		}
		String url = req.getRequestURI() + "?" + req.getQueryString();
		if (session != null && session.getAttribute("UserName") != null) {
			if (!req.getRequestURI().endsWith("LoginServlet")) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/studentsServlet");
			}
		} else {
			if (req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chain.doFilter(request, response);
			} else {
				req.setAttribute("url", url);
				req.getRequestDispatcher("/Login.jsp").forward(req, res);
			}
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package controller.filter;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setContentType("text/html");
	
		PrintWriter out = res.getWriter();
		HttpSession sessions = req.getSession(false);
//		String user = request.getParameter("user");
//		String passWord = request.getParameter("passWord");
//		boolean flagDefault = false;
//		if(user != null && passWord != null) {
//			if(user.equals("cong") && passWord.equals("12345")) {
//				sessions.setAttribute("user", "cong");
//				flagDefault = true;
//			}else {
//				req.setAttribute("DangNhap", "Thất bại");
//			}
//		}else {
//			if(sessions.getAttribute("user") != null) {
//				if(sessions.getAttribute("user").equals("cong")) {
//					flagDefault = true;
//				}
//			}
//		}
//		
		String url = req.getRequestURI()+"?" + req.getQueryString();
		if (sessions != null && sessions.getAttribute("user") != null) {
			if (!req.getRequestURI().endsWith("Login")) {
				chain.doFilter(request, response);
			} else {
				
				res.sendRedirect(req.getContextPath());
			}
		} else {
			if (req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chain.doFilter(request, response);
			} else {
				req.setAttribute("url", url);
				req.getRequestDispatcher("Login.jsp").forward(req, res);
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

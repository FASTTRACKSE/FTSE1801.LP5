package ftse1801.demo.spring.Filter;

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
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String e = req.getRequestURI()+"?"+req.getQueryString();
		if(session != null && session.getAttribute("userName") != null) {
			if(!req.getRequestURI().endsWith("login")) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath()+ "/listSV");
			}
		}else {
			req.setAttribute("errorMessage", e);
			req.getRequestDispatcher("/view/login.jsp").forward(req, res);
			
		}
//		try {
//			chain.doFilter(request, response);
//		}catch(Exception e) {
//			req.setAttribute("errorMessage", e);
//			req.getRequestDispatcher("/view/login.jsp").forward(req, res);
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

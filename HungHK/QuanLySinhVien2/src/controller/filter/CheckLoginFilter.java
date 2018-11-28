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

    public CheckLoginFilter() {
    	
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String url = request.getRequestURI()+"?" +request.getQueryString();
        if (session != null && session.getAttribute("user")!= null) {
        	if (!request.getRequestURI().endsWith("LoginServlet")) {
            	chain.doFilter(req, res);
        	} else {
        		response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
        	}
        } else {
        	request.setAttribute("url", url);
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

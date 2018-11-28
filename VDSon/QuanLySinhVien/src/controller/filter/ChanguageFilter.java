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

/**
 * Servlet Filter implementation class ChanguageFilter
 */
public class ChanguageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChanguageFilter() {
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
		
		boolean flagDefaultCookie = true;
		
		String langValue = "vi";
		
		if (request.getParameter("lang") != null) {
			langValue = req.getParameter("lang");
		} else {
			Cookie[] cookies = req.getCookies();
			
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("lang".equals(cookie.getName())) {
						flagDefaultCookie = false;
						langValue = cookie.getValue();
						break;
					}
				}
			}
		}
		
		if (flagDefaultCookie) {
			Cookie cookie = new Cookie("lang", langValue);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			res.addCookie(cookie);
		}
		request.setAttribute("lang", langValue);

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

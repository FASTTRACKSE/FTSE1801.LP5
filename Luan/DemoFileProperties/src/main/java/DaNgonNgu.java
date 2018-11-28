package main.java;

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
 * Servlet implementation class DaNgonNgu
 */
public class DaNgonNgu implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean flagDefaultCookie = true;
		String langValue = "en";
		if (req.getParameter("language") != null) {
			langValue = req.getParameter("language");
		} else {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for(Cookie cookie: cookies) {
					if (cookie.getName().equals("lang")) {
						flagDefaultCookie = false;
						langValue = cookie.getValue();
						break;
					}
				}
			}
		}
		
		if (flagDefaultCookie) {
			Cookie cookie = new Cookie("lang", langValue);
			res.addCookie(cookie);
		}
		request.setAttribute("lang", langValue);
		chain.doFilter(request, response);
		
		
		
	}
	@Override
	public void destroy() {
	}
}

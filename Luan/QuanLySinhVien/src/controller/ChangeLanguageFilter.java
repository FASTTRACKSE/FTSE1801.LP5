package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		boolean flagDefaultCookie = true;
		String langValue = "en";

		if (request.getParameter("language") != null) {
			langValue = req.getParameter("language");
		} else {
			Cookie[] cookies = req.getCookies();

			// neu vao trang lan thu 2 tro di cookie se khac null
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					// kiem tra ton tai cookie "lang"
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

}

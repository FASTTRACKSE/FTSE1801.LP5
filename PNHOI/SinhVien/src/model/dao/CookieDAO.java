package model.dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieDAO {
	public String getCookie(HttpServletRequest request) {
		Cookie cookie[] = request.getCookies();
		return cookie[1].getValue();
	}
}

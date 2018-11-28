package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if (session != null && session.getAttribute("id") != null) {
			if (!req.getRequestURI().endsWith("Login.jsp")) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath() +"SinhVienServlet");
			}
		}else {
			if (req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chain.doFilter(request, response);
			} else {
				req.getRequestDispatcher("Login.jsp").forward(req, res);
			}
		}
		
//		boolean flagDefaultSession = false;
//		res.setContentType("text/html");
//		HttpSession session = req.getSession();
//		String name = request.getParameter("id");
//		String pass = request.getParameter("pass");
//		if (name != null && pass != null) {
//			if (name.equals("luan") && pass.equals("12345")) {
//				session.setAttribute("id", name);
//				flagDefaultSession = true;
//			}else {
//				request.setAttribute("thatbai", "thatbai");
//			}
//		}else {
//			if (session.getAttribute("id") != null) {
//				flagDefaultSession = true;
//			}
//		}
//		if (flagDefaultSession) {
//			chain.doFilter(request, response);
//		}else {
//			request.getRequestDispatcher("Login.jsp").forward(request, response);
//		}
		
		
	}

}

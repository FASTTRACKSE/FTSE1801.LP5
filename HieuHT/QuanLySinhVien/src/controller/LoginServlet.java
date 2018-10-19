package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && password != null) {
			if (username.equals("admin") && password.equals("admin")) {
				session.setAttribute("user", username);
				String url = "SinhVienServlet";
				if (request.getParameter("nameUrl") != null
						&& !request.getParameter("nameUrl").equals("/QuanLySinhVien/Login.jsp?null")) {
					url = request.getParameter("nameUrl");
				
				}
				response.sendRedirect(url);
			} else {
				request.setAttribute("ThatBai", "Thất Bại");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}

	}
}

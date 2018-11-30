package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QLSinhVienDAO;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();
		HttpSession session = request.getSession();
		String name = request.getParameter("Name");
		String pass = request.getParameter("password");
		if (name != null && pass != null) {
			if (sinhVienDAO.login(name, pass)) {
				session.setAttribute("name", name);
				String url = "SinhVienServlet";
				if (request.getParameter("nameUrl") != null && !request.getParameter("nameUrl").equals("/QuanLySinhVien/Login.jsp?null")) {
					url = request.getParameter("nameUrl");
				}
				response.sendRedirect(url);
//				 response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
			} else {
				out.println("Sai tài khoản hoặc mật khẩu");
			}
		} else {
			out.println("Sai tài khoản hoặc mật khẩu");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

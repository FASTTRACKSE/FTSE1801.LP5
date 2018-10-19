package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDao;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SinhVienDao sinhVienDao = new SinhVienDao();
		if (request.getParameter("chon") == null) {
			request.getRequestDispatcher("AddSinhVien.jsp").forward(request, response);
		}else {
			sinhVienDao.ThemSinhVien(request.getParameter("maSV"), request.getParameter("tenSV"));
			sinhVienDao.ThemDiem(request.getParameter("maSV"), request.getParameter("monHoc"),
					request.getParameter("diem"));
			response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
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

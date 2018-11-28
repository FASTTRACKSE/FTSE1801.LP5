package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDao;
import model.entity.SinhVien;

/**
 * Servlet implementation class SinhVienServlet
 */
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SinhVienServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SinhVienDao sinhVienDao = new SinhVienDao();
		int total = 3;
		int page = 0;
		int pages = 1;
		int soTrang = sinhVienDao.TotalSV(total);
		if (request.getParameter("page") != null) {
			if (Integer.parseInt(request.getParameter("page")) <= 0
					|| Integer.parseInt(request.getParameter("page")) > soTrang) {

			} else {
				page = Integer.parseInt(request.getParameter("page"));
				pages = page;
				if (page == 1) {
					page = page - 1;
				} else {
					page = page - 1;
					page = page * total;
				}
			}

		}
		ArrayList<SinhVien> listSV = sinhVienDao.ShowAllSinhVien(page, total);
		request.setAttribute("page", pages);
		request.setAttribute("pageBegin", request.getParameter("pageBegin"));
		request.setAttribute("pageEnd", request.getParameter("pageEnd"));
		request.setAttribute("soTrang", soTrang);
		request.setAttribute("listSV", listSV);
		request.getRequestDispatcher("ShowSinhVien.jsp").forward(request, response);

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

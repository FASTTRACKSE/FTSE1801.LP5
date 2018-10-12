package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDao;
import model.entity.SinhVien;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVienDao sinhVienDao = new SinhVienDao();
		if (request.getParameter("chon") == null) {
			SinhVien sinhVien = sinhVienDao.ShowSinhVienTheoMaVS(request.getParameter("maSV"));
			request.setAttribute("sinhVien", sinhVien);
			request.getRequestDispatcher("UpdateSinhVien.jsp").forward(request, response);
		} else {
			sinhVienDao.SuaThongTin(request.getParameter("monHoc"), request.getParameter("diem"), request.getParameter("maSV"));
			response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

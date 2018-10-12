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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDao svdao = new SinhVienDao();
	SinhVien sinhVien;
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("update") == null) {
			String id = request.getParameter("id");
			SinhVien sinhVien = new SinhVien("7", "Hung", "13", "Luong Bang", "1801");
			request.setAttribute("sinhVien", sinhVien);
			request.getRequestDispatcher("UpdateSv.jsp").forward(request, response);
		}else {
			sinhVien = new SinhVien(); 
			sinhVien.setId(request.getParameter("id"));
			sinhVien.setTen(request.getParameter("ten"));
			sinhVien.setTuoi(request.getParameter("tuoi"));
			sinhVien.setDiachi(request.getParameter("diachi"));
			sinhVien.setLop(request.getParameter("lop"));
			
			svdao.UpdateSinhVien(sinhVien, sinhVien.getId());
			response.sendRedirect(request.getContextPath()+"/SinhVienServlet");
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

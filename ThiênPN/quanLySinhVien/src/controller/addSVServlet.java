package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SinhVienDAO;

/**
 * Servlet implementation class addSVServlet
 */
public class addSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SinhVienDAO sinhVienDao = new SinhVienDAO();
	    
			 String maSinhVien = request.getParameter("maSV");
			 String tensinhVien = request.getParameter("tenSV");
			 String password = request.getParameter("passSV");
			 String tuoi = request.getParameter("tuoi");
			 String MH = request.getParameter("MonHoc");
			 int diem = Integer.parseInt(request.getParameter("diem"));
			 
			 sinhVienDao.addSinhVien(maSinhVien, tensinhVien, password,tuoi);
			 sinhVienDao.addDiemSV(maSinhVien, MH, diem);
			 response.sendRedirect("http://localhost:8080/quanLySinhVien/QLSinhVienServlet");
			 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

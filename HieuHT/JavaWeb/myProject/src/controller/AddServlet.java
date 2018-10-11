package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDao;
import model.entity.SinhVien;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVienDao svdao = new SinhVienDao();
		SinhVien sinhvien = new SinhVien();
		
		sinhvien.setId(request.getParameter("id"));
		sinhvien.setTen(request.getParameter("ten"));
		sinhvien.setTuoi(request.getParameter("tuoi"));
		sinhvien.setDiachi(request.getParameter("diachi"));
		sinhvien.setLop(request.getParameter("lop"));
		
		svdao.addSinhVien(sinhvien);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

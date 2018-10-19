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
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String lop;
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVienDao sinhVienDao = new SinhVienDao();
		if(request.getParameter("add").equals("AddSv")) {
			
			String ten = request.getParameter("ten");
			String tuoi = request.getParameter("tuoi");
			String diachi = request.getParameter("diachi");
			String lop = request.getParameter("lop");
			sinhVienDao.addSinhVien(ten, tuoi, diachi, lop);
		}
		
		response.sendRedirect(request.getContextPath()+"/SinhVienServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

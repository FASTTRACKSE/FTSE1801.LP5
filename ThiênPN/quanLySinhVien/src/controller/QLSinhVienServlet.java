package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class QLSinhVienServlet
 */
public class QLSinhVienServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    SinhVienDAO sv = new SinhVienDAO();
    ArrayList<SinhVien> list = new  ArrayList<SinhVien>();
    /**
     * Default constructor. 
     */
    public QLSinhVienServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		list = sv.getAllSinhVien();
		request.setAttribute("SinhVien",list );
		request.getRequestDispatcher("Student.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

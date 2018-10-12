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
	SinhVienDao svdao = new SinhVienDao();
	ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();

	public SinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *s @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listSv = svdao.getSinhVien();
		request.setAttribute("sinhvien", listSv);
		request.getRequestDispatcher("QLsinhvien.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CookieDAO;
import model.dao.StudentsDAO;
import model.entity.Students;

/**
 * Servlet implementation class studentsServlet
 */
public class studentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentsDAO dao = new StudentsDAO();
	CookieDAO dao2 = new CookieDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		int soDong = 5;
		ArrayList<Students> list = new ArrayList<Students>();
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int soTrang = dao.getCount(soDong);
		list = dao.getAll((page - 1)*soDong, soDong);
		request.setAttribute("list", list);
		request.setAttribute("dong", page);
		request.setAttribute("pageBegin", request.getParameter("pageBegin"));
		request.setAttribute("pageEnd", request.getParameter("pageEnd"));
		request.setAttribute("soTrang", soTrang);
		
		if(request.getParameter("login") != null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
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

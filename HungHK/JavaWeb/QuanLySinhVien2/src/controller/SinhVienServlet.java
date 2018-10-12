package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class SinhVienServlet
 */
public class SinhVienServlet extends HttpServlet {
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
//	ArrayList<SinhVien> listSV = new ArrayList<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = 1;
		int soDong = 5;
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		list = sinhVienDAO.getAllSinhVien((page - 1) * soDong, soDong);
		int noOfPages = sinhVienDAO.soTrang(soDong);
		request.setAttribute("soTrang", noOfPages);
		request.setAttribute("sv", list);
		request.setAttribute("trang", page);
		request.setAttribute("noOfPages", noOfPages);
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

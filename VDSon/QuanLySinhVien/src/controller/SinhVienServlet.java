package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QLSinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class SinhVienServlet
 */
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();

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
		ArrayList<SinhVien> list = new ArrayList<>();
		int page = 1;
		int size = 5;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		list = sinhVienDAO.displayAllSinhVien((page - 1) * size, size);
		int noOfPages = sinhVienDAO.soTrang(size);
		request.setAttribute("soTrang", noOfPages);
		request.setAttribute("sv", list);
		request.setAttribute("trang", page);
		request.setAttribute("noOfPages", noOfPages);
		
		
		// String lang = request.getParameter("lang");
		// HttpSession session = request.getSession();
		// session.setAttribute("lang", lang);
		// Map<String, String> map = new HashMap<>();
		// if (request.getParameter("lang") != null) {
		// session.setAttribute("language", request.getParameter("lang"));
		// }
		// if (session.getAttribute("language")!=null) {
		// if (session.getAttribute("language").equals("Vietnamese")) {
		// map = sinhVienDAO.vietnamlaguage();
		// }else {
		// map = sinhVienDAO.englishlanguage();
		// }
		// } else {
		// map = sinhVienDAO.vietnamlaguage();
		// }
		// request.setAttribute("lang", map);
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

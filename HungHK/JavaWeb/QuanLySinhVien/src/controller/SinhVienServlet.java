package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = 0;
		int soDong = 7;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			if (page == 1) {
				page = page - 1;
			} else {
				page = page - 1;
				page = page * soDong;
			}
		}
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		
		int soTrang = sinhVienDAO.getCount(soDong);
		list = sinhVienDAO.getAllSinhVien(page, soDong);
		request.setAttribute("list", list);
		request.setAttribute("dong", request.getParameter("page"));
		request.setAttribute("ccc", soTrang);
		
		String lang = request.getParameter("lang");
		HttpSession session = request.getSession();
		session.setAttribute("lang", lang);
		Map<String, String> map = new HashMap<>();
		if (request.getParameter("lang") != null) {
			session.setAttribute("language", request.getParameter("lang"));
		}
		if (session.getAttribute("language")!=null) {
			if (session.getAttribute("language").equals("Vietnamese")) {
				map = sinhVienDAO.vietnameseLanguage();
			}else {
				map = sinhVienDAO.englishLanguage();
			}
		} else {
			map = sinhVienDAO.vietnameseLanguage();
		}
		request.setAttribute("lang", map);
		
		
		
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

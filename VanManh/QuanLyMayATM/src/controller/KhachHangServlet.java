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

import model.dao.KhachHangDAO;
import model.dao.LanguageDAO;
import model.dao.PageDAO;
import model.dao.PhuongQuanDAO;
import model.dao.TheAtmDAO;
import model.entity.KhachHang;

/**
 * Servlet implementation class KhachHangServlet
 */
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	KhachHangDAO khachHangDAO;
	TheAtmDAO theAtmDAO;
	PhuongQuanDAO phuongQuanDAO;
	PageDAO pageDAO;
	LanguageDAO languageDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		khachHangDAO = new KhachHangDAO();
		theAtmDAO = new TheAtmDAO();
		phuongQuanDAO = new PhuongQuanDAO();
		pageDAO = new PageDAO();
		languageDAO = new LanguageDAO();
		
		Map<String, String> map = new HashMap<>();
		HttpSession session = request.getSession();
		if (request.getParameter("lang")!=null) {
			session.setAttribute("language", request.getParameter("lang"));
		}
		if (session.getAttribute("language")!=null) {
			if (session.getAttribute("language").equals("vietnam")) {
				map = languageDAO.vietNamese();
			}else if(session.getAttribute("language").equals("english")){
				map = languageDAO.english();
			}
		} else {
			map = languageDAO.vietNamese();
		}
		session.setAttribute("lang", map);
			
//		if (request.getParameter("lang")!=null) {
//			Cookie cookie = new Cookie("language", request.getParameter("lang"));
//			response.addCookie(cookie);
//		}
//		
//		if (request.getCookies()!=null) {
//			if (request..equals("vietnam")) {
//				map = languageDAO.vietNamese();
//			} else {
//				map = languageDAO.english();
//			}
//		} else {
//			map = languageDAO.vietNamese();
//		}
//		request.setAttribute("lang", map);
//		
		int count = 5;
		int page = 0;
		int pages = 1;
		int soTrang = pageDAO.countDAO(count);

		if (request.getParameter("page") != null) {
			if (Integer.parseInt(request.getParameter("page")) <= 0
					|| Integer.parseInt(request.getParameter("page")) > soTrang) {
			} else {
				page = Integer.parseInt(request.getParameter("page"));
				pages = page;
				if (page == 1) {
					page = page - 1;
				} else {
					page = page - 1;
					page = page * count;
				}
			}
		}

		ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
		ArrayList<String> listPhuong = phuongQuanDAO.showDanhSachPhuong("Thanh Khê");
		ArrayList<KhachHang> listKH = khachHangDAO.showAllKhachHang(page, count);
		request.setAttribute("pageEnd", request.getParameter("PageEnd"));
		request.setAttribute("pageBegin", request.getParameter("PageBegin"));
		request.setAttribute("page", pages);
		request.setAttribute("soTrang", soTrang);
		request.setAttribute("theATM", listSoThe);
		request.setAttribute("phuong", listPhuong);
		request.setAttribute("listKH", listKH);
		request.getRequestDispatcher("quanLy.jsp").forward(request, response);

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

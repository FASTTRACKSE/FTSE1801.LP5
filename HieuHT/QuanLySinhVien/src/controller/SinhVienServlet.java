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

import model.dao.SinhVienDao;
import model.entity.SinhVien;

/**
 * Servlet implementation class SinhVienServlet
 */
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int String = 0;
	

	public SinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public int pageChanges(int page, int soDong) {
//    	if(page ==1) {
//    		page = page -1;
//    	}else {
//    		page = page -1;
//    		page = page*soDong;
//    	}
//    	return page;
//    }

	/**
	 * s @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// Map<String,String> map = new HashMap<String, String>();
		// NgonNguDao ngonNguDao = new NgonNguDao();
		// if(request.getParameter("lang")!=null) {
		// session.setAttribute("language", request.getParameter("lang"));
		// }
		// if (session.getAttribute("language")!=null) {
		// if (session.getAttribute("language").equals("VietNamese")) {
		// map = ngonNguDao.VietNameseLaguage();
		// }else if(session.getAttribute("language").equals("English")){
		// map = ngonNguDao.EnglishLaguage();
		// }else {
		// map = ngonNguDao.TrungQuocLaguage();
		// }
		// }else {
		// map = ngonNguDao.VietNameseLaguage();
		// }
		// session.setAttribute("lang", map);
		// listSv = svdao.getSinhVien();
		// request.setAttribute("sinhvien", listSv);
		// request.getRequestDispatcher("QLsinhvien.jsp").forward(request, response);

		int page = 1;
		int soDong = 3;
		SinhVienDao sinhVien = new SinhVienDao();
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		listSV = sinhVien.getAllSinhVien((page-1)*soDong, soDong);
		int soTrang = sinhVien.getCount(soDong);
		
		//request.setAttribute("sinhvien", listSv);
		request.setAttribute("listSv", listSV);
		request.setAttribute("page", page);
		request.setAttribute("soTrang", soTrang);
		request.setAttribute("pageBegin", request.getParameter("pageBegin"));
		request.setAttribute("pageEnd", request.getParameter("pageEnd"));
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

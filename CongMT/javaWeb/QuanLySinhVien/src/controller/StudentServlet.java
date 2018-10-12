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

import model.dao.NgonNguDao;
import model.dao.StudentDao;
import model.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDao studentDao = new StudentDao();
       ArrayList<Student> listSv = new ArrayList<Student>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int pageChanges(int page, int soDong) {
    	if(page == 1){
			page = page -1;
		}else {
			page = page -1;
			page = page*soDong;
		}
		return page;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String lang = request.getParameter("lang");
//		Cookie ck = new Cookie("ngonNgu",lang);
//
//		if(lang!=null) {
//			if (lang.equals("Vietnamese")) {
//				request.setAttribute("ngonNgu", "vi");
//			}else {
//				request.setAttribute("ngonNgu", "en");
//			}
//		}else {
//			request.setAttribute("ngonNgu", "vi");
//		}
//		response.addCookie(ck);
//		request.getRequestDispatcher("DemoNgonNgu1.jsp").forward(request, response);
		
//		NgonNguDao ngonNguDao = new NgonNguDao();
//		HttpSession session = request.getSession();
//		Map<String, String> map = new HashMap<>();
//		
//		if (request.getParameter("lang") != null) {
//			session.setAttribute("language", request.getParameter("lang"));
//		}
//		if(session.getAttribute("language")!=null) {
//			if(session.getAttribute("language").equals("Vietnamese")) {
//				map = ngonNguDao.vietnameseLanguage();
//			}else if(session.getAttribute("language").equals("English")) {
//				map = ngonNguDao.englishLanguage();
//			}
//		}else {
//			map = ngonNguDao.vietnameseLanguage();
//		}
//
//		session.setAttribute("lang", map);
		
		int page = 1;
		int pages=1;
		int soDong = 3;
		
//		Cookie cookie[] = request.getCookies();
//		if(cookie[1].getValue() !=null) {
//			if(cookie[1].getValue().equals("vi")) {
//				request.setAttribute("ngonNgu", "vi");
//			}else {
//				request.setAttribute("ngonNgu", "en");
//			}
//		}else {
//			request.setAttribute("ngonNgu", "vi");
//		}
		StudentDao student = new StudentDao();
		int soTrang = student.getCount(soDong);

		if (request.getParameter("chon") != null) {
			if (request.getParameter("chon").equals("<")) {
				page = Integer.parseInt(request.getParameter("pages")) - 1;
				pages = page;
				page = pageChanges(page, soDong);
			}else if (request.getParameter("chon").equals(">")) {
				page = Integer.parseInt(request.getParameter("pages")) + 1;
				pages = page;
				page = pageChanges(page, soDong);
			}else if (request.getParameter("chon").equals("|<")) {
				page = 1;
				pages = page;
				page = pageChanges(page, soDong);
			}else {
				page = soTrang;
				pages = page;
				page = pageChanges(page, soDong);
			}
		}
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			pages =page;
			page = pageChanges(page, soDong);
		}
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list = student.getAllStudent((pages-1)* soDong, soDong);
		request.setAttribute("list", list);
		request.setAttribute("page", pages);
		request.setAttribute("soTrang", soTrang);
		request.setAttribute("pageBegin", request.getParameter("pageBegin"));
		request.setAttribute("pageEnd", request.getParameter("pageEnd"));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

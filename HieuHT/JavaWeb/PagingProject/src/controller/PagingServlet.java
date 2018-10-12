package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.QuocgiaDao;
import model.entity.QuocGia;

/**
 * Servlet implementation class PagingServlet
 */
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuocgiaDao qgdao = new QuocgiaDao();
	ArrayList<QuocGia> listQg = new ArrayList<QuocGia>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int pageChanges(int page, int soDong) {
    	if(page ==1) {
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
		int page = 0;
		int pages = 1;
		int soDong = 20;
		String lang = null;
		Cookie cookie[] = request.getCookies();
		for(int i = 0;i<cookie.length; i++) {
			if(cookie[i].getName().equals("language")) {
				lang = cookie[i].getValue();
			}else {
				lang = "vi";
			}
		}
		if (request.getParameter("chon") != null) {
			page = Integer.parseInt(request.getParameter("chon"));
			pages = page;
			if(page == 1) {
				page = page -1;
			}else {
				page = page -1;
				page = page*soDong;
			}
		}
		QuocgiaDao quocGia = new QuocgiaDao();
		ArrayList<QuocGia> listQG = quocGia.getAllQuocGia(page,soDong);
		int soTrang = quocGia.getCount(soDong);
		listQG = quocGia.getAllQuocGia(page, soDong);
		request.setAttribute("lang", lang);
		request.setAttribute("quocgia", listQg);
		request.setAttribute("listQg", listQG);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

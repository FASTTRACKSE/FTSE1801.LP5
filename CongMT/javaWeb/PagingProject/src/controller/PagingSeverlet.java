package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CityDao;
import model.entity.ThanhPho;

/**
 * Servlet implementation class PagingSeverlet
 */
public class PagingSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingSeverlet() {
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
		int page = 0;
		int pages=1;
		int soDong = 10;
		CityDao city = new CityDao();
		int soTrang = city.getCount(soDong);

		if (request.getParameter("chon") != null) {
			if (request.getParameter("chon").equals("back")) {
				page = Integer.parseInt(request.getParameter("pages")) - 1;
				pages = page;
				page = pageChanges(page, soDong);
			}else if (request.getParameter("chon").equals("next")) {
				page = Integer.parseInt(request.getParameter("pages")) + 1;
				pages = page;
				page = pageChanges(page, soDong);
			}else if (request.getParameter("chon").equals("begin")) {
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
		
		ArrayList<ThanhPho> list = new ArrayList<ThanhPho>();
		list = city.getAllCity(page, soDong);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

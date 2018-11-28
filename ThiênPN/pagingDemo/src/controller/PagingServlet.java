package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.thuvienDao;
import model.entity.Quan;

/**
 * Servlet implementation class PagingServlet
 */
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int page = 0;
		int page = 1;
		int soDong = 10;

		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));}
		thuvienDao Dao = new thuvienDao();
		ArrayList<Quan> list = new ArrayList<Quan>();
		list = Dao.getQuan((page-1)*soDong, soDong);
		int soTrang = Dao.getCount(soDong);
		
		request.setAttribute("list", list);
		request.setAttribute("dong", page);
		request.setAttribute("Begin", request.getParameter("Begin"));
		request.setAttribute("End", request.getParameter("End"));
		request.setAttribute("soTrang", soTrang);
		request.getRequestDispatcher("phanTrang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

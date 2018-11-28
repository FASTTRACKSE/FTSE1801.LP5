package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ThanhPhoDAO;
import model.entity.ThanhPho;

/**
 * Servlet implementation class PagingServlet
 */
public class PagingServlet extends HttpServlet {
	ThanhPhoDAO dao = new ThanhPhoDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
        int soDong = 10;
        if(request.getParameter("page") != null) {
        	page = Integer.parseInt(request.getParameter("page"));
        	
        }
            
        ThanhPhoDAO dao = new ThanhPhoDAO();
        ArrayList<ThanhPho> list = new ArrayList<ThanhPho>();
        
        int soTrang = dao.getCount(soDong);
        list = dao.getAll((page-1),soDong);
        request.setAttribute("list", list);
        request.setAttribute("dong", page);
        request.setAttribute("pageBegin", request.getParameter("pageBegin"));
        request.setAttribute("pageEnd", request.getParameter("pageEnd"));
        request.setAttribute("soTrang", soTrang);
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

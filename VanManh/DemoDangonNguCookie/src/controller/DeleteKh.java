package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.KhachHangDAO;

/**
 * Servlet implementation class DeleteKh
 */
public class DeleteKh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       KhachHangDAO khachHangDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String a = request.getParameter("MaKH");
		khachHangDAO = new KhachHangDAO();
		khachHangDAO.deleteKhachHangTheoMaKH(a);
		response.sendRedirect(request.getContextPath() + "/KhachHangServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

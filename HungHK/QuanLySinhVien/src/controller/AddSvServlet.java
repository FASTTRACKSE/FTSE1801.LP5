package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SinhVienDAO;

/**
 * Servlet implementation class AddSvServlet
 */
public class AddSvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVienDAO sinhVienDao = new SinhVienDAO();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		sinhVienDao.addSinhVienByMaSV(id, name, age);
		response.sendRedirect(request.getContextPath()+"/SinhVienServlet");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

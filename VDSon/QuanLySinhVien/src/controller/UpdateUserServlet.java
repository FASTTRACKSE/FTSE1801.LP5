package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QLSinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("sua")==null) {
			QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();
			
			String id = request.getParameter("id1");
			SinhVien sinhVien = sinhVienDAO.displaySinhVientheoMa(id);
			request.setAttribute("sv", sinhVien);
			request.getRequestDispatcher("UpdateStudents.jsp").forward(request, response);
		} else {
			QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			sinhVienDAO.updateSinhVienByMaSV(name, age, id);
			response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

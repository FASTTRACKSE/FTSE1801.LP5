package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentsDAO;
import model.entity.Students;

/**
 * Servlet implementation class addServlet
 */
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentsDAO dao;
    Students students;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao = new StudentsDAO();
		students = new Students();
		students.setId(request.getParameter("id"));
		students.setName(request.getParameter("name"));
		students.setAge(request.getParameter("age"));
		students.setAddress(request.getParameter("address"));
		dao.addNewSinhVien(students);
		response.sendRedirect(request.getContextPath()+"/studentsServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

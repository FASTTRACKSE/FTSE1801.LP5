package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentDao;
import model.entity.Student;

/**
 * Servlet implementation class DeletelStudent
 */
public class DeletelStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 StudentDao studentDao = new StudentDao();
     ArrayList<Student> listSv = new ArrayList<Student>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletelStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("IdStudent");
		
		studentDao.deletelStudent(id);
		response.sendRedirect(request.getContextPath() + "/StudentServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

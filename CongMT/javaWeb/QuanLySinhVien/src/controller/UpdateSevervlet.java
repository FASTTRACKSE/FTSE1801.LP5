package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentDao;
import model.entity.Student;

/**
 * Servlet implementation class UpdateSevervlet
 */
public class UpdateSevervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Student student;
       StudentDao studentDao =  new StudentDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSevervlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie cookie[] = null;
//		cookie = request.getCookies();
//		cookie[1].getValue();
//		if (cookie[1].getValue().equals("vi")) {
//			request.setAttribute("ngonNgu", "vi");
//		}else {
//			request.setAttribute("ngonNgu", "en");
//		}
		Cookie cookie[] = request.getCookies();
		if(cookie[1].getValue() !=null) {
			if(cookie[1].getValue().equals("vi")) {
				request.setAttribute("ngonNgu", "vi");
			}else {
				request.setAttribute("ngonNgu", "en");
			}
		}else {
			request.setAttribute("ngonNgu", "vi");
		}
		
		if(request.getParameter("nutchon") == null) {
			String id = request.getParameter("IdStudent");
			Student student = studentDao.getAllByStudent(id);
			request.setAttribute("student", student);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		}else {
			student = new Student();
			student.setId(request.getParameter("id"));
			student.setName(request.getParameter("name"));
			student.setOld(request.getParameter("old"));
			student.setAdress(request.getParameter("adress"));
			student.setNumberPhone(request.getParameter("number"));
			
			studentDao.editStudent(student, student.getId());
			response.sendRedirect(request.getContextPath()+"/StudentServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

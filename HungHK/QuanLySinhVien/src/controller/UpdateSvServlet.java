package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SinhVienDAO;

/**
 * Servlet implementation class UpdateSvServlet
 */
public class UpdateSvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static String id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("sua") == null) {
			id = request.getParameter("id1");
			request.getRequestDispatcher("updateSv.jsp").forward(request, response);
		} else {
			SinhVienDAO sinhVienDAO = new SinhVienDAO();
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			sinhVienDAO.updateSinhVienByMaSV(name, age, id);
			response.sendRedirect(request.getContextPath() +"/SinhVienServlet");
		}
		
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		String lang = request.getParameter("lang");
		HttpSession session = request.getSession();
		session.setAttribute("lang", lang);
		Map<String, String> map = new HashMap<>();
		if (request.getParameter("lang") != null) {
			session.setAttribute("language", request.getParameter("lang"));
		}
		if (session.getAttribute("language")!=null) {
			if (session.getAttribute("language").equals("Vietnamese")) {
				map = sinhVienDAO.vietnameseLanguage();
			}else {
				map = sinhVienDAO.englishLanguage();
			}
		} else {
			map = sinhVienDAO.vietnameseLanguage();
		}
		request.setAttribute("lang", map);
		request.getRequestDispatcher("updateSv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

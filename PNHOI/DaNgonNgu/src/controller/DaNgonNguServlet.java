package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.NgonNguDao;

/**
 * Servlet implementation class DaNgonNguServlet
 */
@WebServlet("/DaNgonNguServlet")
public class DaNgonNguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaNgonNguServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NgonNguDao dao = new NgonNguDao();
		String lang = request.getParameter("lang");
		HttpSession session = request.getSession();
		Map<String, String> showLanguage = new HashMap<>();
		showLanguage = dao.vietNam();
		if(lang != null) {
			session.setAttribute("lang", lang);
		}
		if (session.getAttribute("lang")!=null) {
			if (session.getAttribute("lang").equals("Vietnamese")) {
				showLanguage = dao.vietNam();
			}else {
				showLanguage = dao.engligh();
			}
		} else {
			showLanguage = dao.vietNam();
		}
		request.setAttribute("showLanguage", showLanguage);
		request.getRequestDispatcher("Demo.jsp").forward(request, response);
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

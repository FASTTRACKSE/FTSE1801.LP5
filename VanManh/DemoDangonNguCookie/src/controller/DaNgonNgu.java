package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DaNgonNgu
 */
public class DaNgonNgu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaNgonNgu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		if (request.getParameter("page") != null) {
			page = request.getParameter("page");
		}
		if (request.getParameter("lang") != null) {
			if (request.getParameter("lang").equals("vi")) {
				Cookie cookie2 = new Cookie("language", "vi");
				response.addCookie(cookie2);
			}else{
				Cookie cookie2 = new Cookie("language", "en");
				response.addCookie(cookie2);
			}
		}
		response.sendRedirect(request.getContextPath()+"/KhachHangServlet?page="+page);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

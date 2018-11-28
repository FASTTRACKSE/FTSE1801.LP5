package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoNgonNguServlet
 */
public class DemoNgonNguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoNgonNguServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		if(request.getParameter("page") != null) {
			page =request.getParameter("page");
		}
		
		
		
		String lang = request.getParameter("lang");
//		Cookie ck = new Cookie("ngonNgu",lang);

		if(lang!=null) {
			if (lang.equals("vi")) {
				Cookie ck = new Cookie("ngonNgu", "vi");
				response.addCookie(ck);
			}else {
				Cookie ck = new Cookie("ngonNgu", "en");
				response.addCookie(ck);
			}
		}
		response.sendRedirect(request.getContextPath() + "/StudentServlet?page=" + page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chageLanguage
 */
public class changeLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeLanguage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		if(request.getParameter("page")!=null) {
			page = request.getParameter("page");
		}
		if(request.getParameter("lang")!=null) {
			if (request.getParameter("lang").equals("Vietnamese")) {
				Cookie ck = new Cookie("language","vi");
				ck.setMaxAge(60*60*24*365);
				response.addCookie(ck);
			}else if(request.getParameter("lang").equals("English")){
				Cookie ck = new Cookie("language","en");
				ck.setMaxAge(60*60*24*365);
				response.addCookie(ck);
			}else {
				Cookie ck = new Cookie("language","中国");
				ck.setMaxAge(60*60*24*365);
				response.addCookie(ck);
			}
		}
		response.sendRedirect(request.getContextPath()+"/PagingServlet?page="+page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

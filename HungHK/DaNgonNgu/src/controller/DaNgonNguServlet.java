package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DaNgonNguServlet
 */
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
		String n = request.getParameter("n");
		Cookie ck = new Cookie("user", n);
		if(n != null) {
			if(n.equals("vi")) {
				request.setAttribute("lang", "vi");
			} else {
				request.setAttribute("lang", "en");
			}
			
		} else {
			request.setAttribute("lang", "vi");
		}
		response.addCookie(ck);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

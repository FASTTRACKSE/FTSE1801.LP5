package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("id");
		String pass = request.getParameter("pass");
		boolean flagDefaultSession = false;
		if (name != null && pass != null) {
			if (name.equals("luan") && pass.equals("12345")) {
				session.setAttribute("id", name);
			}else {
				request.setAttribute("thatbai", "");
				flagDefaultSession = true;
			}
		}
		
		if (flagDefaultSession) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);;
		}else {
			request.getRequestDispatcher("SinhVienServlet").forward(request, response);;
		}
		
	}

}

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		HttpSession session = request.getSession();
		
		if(userName != null || password != null) {
			if(userName.equals("Hoi") && password.equals("123")) {
				session.setAttribute("UserName", userName);
				String url = "studentsServlet";
				if (request.getParameter("nameURL") != null && !request.getParameter("nameURL").equals("/SinhVien/Login.jsp?null")) {
					url = request.getParameter("nameURL");
					System.out.println(url);
				}
				response.sendRedirect(url);
//				response.sendRedirect(request.getContextPath() + "/studentsServlet");
				System.out.println(request.getParameter("nameURL"));
			}
		}else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		

	}

}

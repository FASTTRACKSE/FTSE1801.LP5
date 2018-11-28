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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String UserName = request.getParameter("UserName");
		String PassWord = request.getParameter("Password");
		if(UserName!=null && PassWord!=null) {
			if(UserName.equals("luanngao123")&&PassWord.equals("12345")) {
				session.setAttribute("user", UserName);
				String url = "QLSinhVienServlet";
				if(request.getParameter("nameUrl")!=null && !request.getParameter("nameUrl").equals("quanlySinhVien/Login.jsp?null")) {
					url = request.getParameter("nameUrl");
				}
				response.sendRedirect(url);
			}else {
				request.setAttribute("ThatBai","Thất Bại");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}

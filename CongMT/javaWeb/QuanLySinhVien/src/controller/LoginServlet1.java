package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user = request.getParameter("user");
		String passWord = request.getParameter("passWord");
		HttpSession sessions = request.getSession();
		
		if(user != null && passWord != null) {
			String url= "StudentServlet";
			if(user.equals("cong") && passWord.equals("12345")) {
				sessions.setAttribute("user", user);
				if(request.getParameter("nameUrl") != null && !request.getParameter("nameUrl").equals("/QuanLySinhVien/Login.jsp?null")) {
					url = request.getParameter("nameUrl");
				}
				response.sendRedirect(url);
//				response.sendRedirect(request.getContextPath() + "/StudentServlet");
			}else {
				request.setAttribute("DangNhap", "Thất bại");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
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

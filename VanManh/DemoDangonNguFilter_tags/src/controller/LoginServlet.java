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
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("tk");
		String passWord = request.getParameter("mk");
		HttpSession session = request.getSession();
		boolean chainLogin = false;
		if (userName != null || passWord != null) {
			if (userName.equals("vanmanh")&&passWord.equals("123")) {
				session.setAttribute("userName", "Van Manh");
			}else {
				chainLogin = true;
				request.setAttribute("DangNhap", "ThatBai");
			}
		}
		String url = "KhachHangServlet";
		if (request.getParameter("Url") != null && !request.getParameter("Url").equals("/Login.jsp?null")) {
			url = request.getParameter("Url");
		}
		if (chainLogin) {
			request.setAttribute("URL", url);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}

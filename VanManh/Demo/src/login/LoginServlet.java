package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("user")!= null && request.getParameter("pass")!=null) {
			if (request.getParameter("user").equals("Van Manh")&&request.getParameter("pass").equals("123")) {
				request.setAttribute("user", request.getParameter("user"));
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/Login.jsp");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		}
	
	}

}

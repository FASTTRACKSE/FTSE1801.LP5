

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.print("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>Login</h1>\r\n" + 
				"	<form action=\"DemoServlet\" method=\"post\">\r\n" + 
				"	User name: <input type=\"text\" name=\"user\">\r\n" + 
				"	Password: <input type=\"password\" name=\"pass\">\r\n" + 
				"	<input type=\"submit\" name=\"sub\" value=\"Login\">\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(name.equals("Hoi") && pass.equals("123")){
			out.print("hello"+name);
		}else{
			out.print("dang nhap that bai");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

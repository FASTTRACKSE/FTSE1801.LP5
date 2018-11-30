package demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloServlet
 */
public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public helloServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream in = response.getOutputStream();
		in.println("<html>");
		in.println(
				"<head><title>Login</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>");
		in.println("<body>");
		in.println("<h3>login</h3>");
		in.println("<form action='helloServlet' method='post'>");
		in.println("user: <input type='text' name='Name'/>");
		in.println("pass: <input type='password' name='password'/>");
		in.println("<input type='submit' value='Login'/>");
		in.println("</form>");
		in.println("</body>");
		in.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		String pass = request.getParameter("password");
		if (name != null && pass != null) {
			if (name.equals("son") && pass.equals("123")) {
				out.println("xin chào" + name);
			} else {
				out.println("Sai mk hoặc tên đăng nhập cmnr bạn ơi!!!!!!");
			}
		} else {
			out.println("Xin mời nhập user or pass");
		}

		doGet(request, response);
	}

}

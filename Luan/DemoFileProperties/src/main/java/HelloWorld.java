package main.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorld() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("lang") != null) {
			if (request.getParameter("lang").equals("Vietnamese")) {
				Cookie cookie = new Cookie("language", "vi");
				response.addCookie(cookie);
				request.setAttribute("language", "vi");
			} else if (request.getParameter("lang").equals("English")) {
				Cookie cookie = new Cookie("language", "en");
				response.addCookie(cookie);
				request.setAttribute("language", "en");
			}
		} else {
			Cookie cookie = new Cookie("language", "en");
			response.addCookie(cookie);
			request.setAttribute("language", "en");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

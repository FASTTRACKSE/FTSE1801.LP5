package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo
 */
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double SoA = Double.parseDouble(request.getParameter("a1"));
		double SoB = Double.parseDouble(request.getParameter("b1"));
		double SoC = Double.parseDouble(request.getParameter("c1"));
		double dt = (SoB*SoB) - (4*SoA*SoC);
		double x = 0;
		double x2 = 0;
		request.setAttribute("a", SoA);
		request.setAttribute("b", SoB);
		request.setAttribute("c", SoC);
		request.setAttribute("x", x);
		request.setAttribute("x2", x2);
		request.setAttribute("dt", dt);
		request.getRequestDispatcher("ketQua.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

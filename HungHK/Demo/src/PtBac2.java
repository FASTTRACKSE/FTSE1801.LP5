

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PtBac2
 */
public class PtBac2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PtBac2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		
		double heSoA = Double.parseDouble(request.getParameter("a"));
		double heSoB = Double.parseDouble(request.getParameter("b"));
		double heSoC = Double.parseDouble(request.getParameter("c"));
		double dt = heSoB * heSoB - 4* heSoA * heSoC;
		request.setAttribute("a", heSoA);
		request.setAttribute("b", heSoB);
		request.setAttribute("c", heSoC);
		request.setAttribute("dt", dt);
		request.getRequestDispatcher("PtBac2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mayTinhServlet
 */
public class mayTinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mayTinhServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int soA = Integer.parseInt(request.getParameter("soA"));
		int soB = Integer.parseInt(request.getParameter("soB"));
		int ketQua = 0;

		if (request.getParameter("phepTinh").equals("+")) {
			ketQua = soA + soB;
		} else if (request.getParameter("phepTinh").equals("-")) {
			ketQua = soA - soB;
		} else if (request.getParameter("phepTinh").equals("*")) {
			ketQua = soA * soB;
		} else if (request.getParameter("phepTinh").equals("/")) {
			ketQua = soA / soB;
		}
		request.setAttribute("ketQua", ketQua);
		request.getRequestDispatcher("MayTinh.jsp").forward(request, response);
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

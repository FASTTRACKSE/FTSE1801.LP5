
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class giaiPTBac2
 */
public class giaiPTBac2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public giaiPTBac2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String x1 = null;
		String x2 = null;
		if (!request.getParameter("SoA").matches("[0-9]+") || !request.getParameter("SoB").matches("[0-9]+")
				|| !request.getParameter("SoC").matches("[0-9]+")) {
			x1 = "Vui long khong de trong hoac nhap chu";
		} else {
			int a = Integer.parseInt(request.getParameter("SoA"));
			int b = Integer.parseInt(request.getParameter("SoB"));
			int c = Integer.parseInt(request.getParameter("SoC"));
			double dt = 0.0;

			if (a == 0) {
				if ((b == 0) && (c == 0)) {
					x1 = "Phuong trinh vo so nghiem";
				} else if (b != 0) {
					x1 = "phuong trinh co nghiem la : " + (-c / b);
				} else {
					x1 = "Phuong trinh vo nghiem";
				}
			} else {
				dt = b * b - 4 * a * c;
				if (dt < 0) {
					x1 = "Phuong trinh vo nghiem";
				} else if (dt == 0) {
					x1 = "Phuong trinh co nghiem kep la: " + (-b / (2 * a));
				} else {
					x1 = "" + ((-b + Math.sqrt(dt)) / (2 * a));
					x2 = "" + ((-b - Math.sqrt(dt)) / (2 * a));
				}
			}
		}

		request.setAttribute("x1", x1);
		request.setAttribute("x2", x2);
		request.getRequestDispatcher("Assignment1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

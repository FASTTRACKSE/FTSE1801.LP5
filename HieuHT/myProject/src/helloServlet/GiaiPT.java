package helloServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class giaiPT
 */
public class GiaiPT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GiaiPT() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));

		double delta = Math.pow(b,2)- 4*a*c;
		double ketqua = 0;
		if (a == 0) {
			String bac1 ="Phương trình bậc nhất";
			request.setAttribute("ten",bac1);
			if (b == 0) {
				if (c == 0) {
					
					request.setAttribute("ten","phương trình vô số nghiệm");
				}else {
					
					request.setAttribute("ten","phương trình vô nghiệm");
				}
			}else {
				ketqua = -c/b;
				request.setAttribute("ten","phương trình có  nghiệm"+ ketqua);
			}
			request.getRequestDispatcher("tenPT.jsp").forward(request, response);
		}else {
			if(delta<0) {
				request.setAttribute("ten","phương trình vô nghiệm");
			}else if(delta==0) {
				ketqua = -b/2*a;
				request.setAttribute("ten","phương trình có nghiệm kép"+ ketqua);
			}else if(delta>0) {
				double ketqua1 = (-b + Math.sqrt(delta))/(2*a);
				double ketqua2 = (-b - Math.sqrt(delta))/(2*a);
				request.setAttribute("ten","phương trình có 2 nghiệm phân biệt: " + ketqua1 + ketqua2);
				
			}
			request.getRequestDispatcher("tenPT.jsp").forward(request, response);
		}
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


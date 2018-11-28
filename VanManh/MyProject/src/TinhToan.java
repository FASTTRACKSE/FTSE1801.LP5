

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhToan
 */
public class TinhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinhToan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int	a = Integer.parseInt(request.getParameter("SoA"));
		int	b = Integer.parseInt(request.getParameter("SoB"));
		int ketQua = 0;
			if (request.getParameter("Tinh").equals("+")) {
				ketQua = a+b;
			}else if (request.getParameter("Tinh").equals("-")) {
				ketQua = a-b;
			} else if (request.getParameter("Tinh").equals("*")){
				ketQua = a*b;
			}else {
				ketQua = a/b;
			}
			request.setAttribute("ketQua", ketQua);
			request.getRequestDispatcher("BaiTap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

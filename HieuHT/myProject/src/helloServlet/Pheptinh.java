package helloServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pheptinh
 */
public class Pheptinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pheptinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double soA = Double.parseDouble(request.getParameter("soA"));
		double soB = Double.parseDouble(request.getParameter("soB"));
		String phepTinh = request.getParameter("pheptinh");
		double tinh = 0;
		String ketqua = "";
		if(phepTinh.equals("+")) {
			tinh = soA+soB;
			ketqua = String.valueOf(tinh);
			request.setAttribute("tinhToan", ketqua);
			request.getRequestDispatcher("phepCong.jsp").forward(request, response);

		}else if(phepTinh.equals("-")) {
			tinh = soA-soB;
			ketqua = String.valueOf(tinh);
			request.setAttribute("tinhtoan1", ketqua);
			request.getRequestDispatcher("phepTru.jsp").forward(request, response);
		}else if(phepTinh.equals("*")) {
			tinh = soA*soB;
			ketqua = String.valueOf(tinh);
			request.setAttribute("tinhtoan2", ketqua);
			request.getRequestDispatcher("phepNhan.jsp").forward(request, response);
		}else if(phepTinh.equals("/")) {
			tinh = soA/soB;
			ketqua = String.valueOf(tinh);
			request.setAttribute("tinhtoan3", ketqua);
			request.getRequestDispatcher("phepChia.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package helloSeverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hello
 */
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String a = "Quốc + Nam";
//		//String[] students = {"Nam","Vân","Trang","Vũ"};
//		String user = request.getParameter("firstName");
//		String pass = request.getParameter("lastName");
//		request.setAttribute("username", a);
//	//	request.setAttribute("list", students);
//		if(user.equals("abc") && pass.equals("123")) {
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}else {
//			request.getRequestDispatcher("nono.jsp").forward(request, response);
//		}
		  int soA =Integer.parseInt(request.getParameter("a"));
		  int soB = Integer.parseInt(request.getParameter("b"));
		String phepTinh = request.getParameter("phepTinh");
		int  ketQua = 0;
		
		if(phepTinh.equals("+")) {
			ketQua = soA + soB;
			request.setAttribute("ketQua", ketQua);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else if(phepTinh.equals("-")) {
			ketQua = soA - soB;
			request.setAttribute("ketQua", ketQua);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(phepTinh.equals("x")) {
			ketQua = soA*soB;
			request.setAttribute("ketQua", ketQua);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(phepTinh.equals("/")) {
			ketQua = soA/soB;
			request.setAttribute("ketQua", ketQua);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
		 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

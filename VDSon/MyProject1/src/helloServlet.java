

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloServlet
 */
public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SinhVienDAO sinhViendao = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String a = "Son";
//		request.setAttribute("username", a);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<h2>HelloWord</h2>");
//		out.println("<hr>");
//		out.println("Time on the server is: "+ new java.util.Date());
//		out.println("</body></htmml>");
//		
//		out.println("Student Name: " +request.getParameter("ten dem")+" "+ request.getParameter("ten cuoi"));
		
//		String [] students = {"Nam", "Trang", "Van", "Vu"};
//		request.setAttribute("list", students);
//		
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
//		int soA = Integer.parseInt(request.getParameter("a"));
//		int soB = Integer.parseInt(request.getParameter("b"));
//		String phepTinh = request.getParameter("phepTinh");
//		PrintWriter out = response.getWriter();
//		int ketQua = 0;
//		if (phepTinh.equals("+")) {
//			ketQua = soA+soB;
//			out.println("Tong: "+ketQua);
//		} else if (phepTinh.equals("-")) {
//			ketQua = soA - soB;
//			out.println("Hieu: "+ketQua);
//		} else if (phepTinh.equals("x")) {
//			ketQua = soA * soB;
//			out.println("Tich: "+ketQua);
//		} else if (phepTinh.equals("/")) {
//			ketQua = soA / soB;
//			out.println("Thuong: "+ketQua);
//		}
		
//		double SoA = Double.parseDouble(request.getParameter("a1"));
//		double SoB = Double.parseDouble(request.getParameter("b1"));
//		double SoC = Double.parseDouble(request.getParameter("c1"));
//		double dt = (SoB*SoB) - (4*SoA*SoC);
//		double x = 0;
//		double x2 = 0;
//		if (SoA==0) {
//			if((SoB==0) && (SoC == 0)) {
////				out.println("Phương trình vô số nghiệm");
//				request.setAttribute("x", "Phương trình vô số nghiệm");
//			} else if ((SoB == 0) && (SoC != 0))  {
////				out.println("Phương trình vô nghiệm");
//				request.setAttribute("x", "Phương trình vô nghiệm");
//			} else {
//				x = -(SoC / SoB); 
////				out.println("Phương trình có nghiệm: " +x);
//				request.setAttribute("x", "x");
//			}
//		} else {
//			if (dt<0) {
////				out.println("Phương trình vô nghiệm");
//				request.setAttribute("x", "Phương trình vô nghiệm");
//			} else if (dt == 0) {
//				x = (-SoB/2*SoA);
////				out.println("Phương trình có nghiệm kép: " +x);
//				request.setAttribute("x", x);
//			} else {
//				x = ((-SoB + Math.sqrt(dt))/2*SoA);
//				x2 = ((-SoB - Math.sqrt(dt))/2*SoA);
////				out.println("Phương trình có 2 nghiệm phân biệt: " +x + " và "+x2);
//				request.setAttribute("x", x + " và " + x2);
//			}
//		}
//		request.getRequestDispatcher("ketQua.jsp").forward(request, response);
		
//		ArrayList<String> list  = new ArrayList<>();
//		list.add("Sơn");
//		list.add("Thiên");
//		list.add("Hưng");
//		list.add("Mạnh");
//		list.add("Hợi");
//		request.setAttribute("a",list);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		ArrayList<SinhVien> list1 = new ArrayList<>();
		list1 = sinhViendao.getSinhVien();
		request.setAttribute("b", list1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

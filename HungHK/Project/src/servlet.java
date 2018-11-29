

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = "Hưng";
		request.setAttribute("username", a);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
//		out.println(" Time on the server is: " + new java.util.Date());
//		out.println(" Student Name: " + request.getParameter("firstName") + " " + request.getParameter("lastName"));
		
//		int soA = Integer.parseInt(request.getParameter("a"));
//		int soB = Integer.parseInt(request.getParameter("b"));
//		String phepTinh = request.getParameter("phepTinh");
//		double ket = 0;
//		if (phepTinh.equals(" + ")) {
//			ket = soA + soB;
//			out.println("Tong la: " + ket);
//		} else if (phepTinh.equals(" - ")) {
//			ket = soA - soB;
//			out.println("Hieu la: " + ket);
//		} else if (phepTinh.equals(" * ")) {
//			ket = soA * soB;
//			out.println("Tich la: " + ket);
//		} else if (phepTinh.equals(" / ")) {
//			ket = soA / soB;
//			out.println("Thuong la: " + ket);
//		}
		
		
		double heSoA = Double.parseDouble(request.getParameter("a"));
		double heSoB = Double.parseDouble(request.getParameter("b"));
		double heSoC = Double.parseDouble(request.getParameter("c"));
//		double kq = 0;
		if (heSoA == 0) {
			if (heSoB == 0) {
				if (heSoC == 0) {
					out.println("Phương trình có vô số nghiệm");
				} else {
					out.println("Phương trình vô nghiệm");
				}
			} else {
				out.println("Phương trình có 1 x1 = " + (heSoC / heSoB));
			}
		} else {
			double delta = heSoB*heSoB - 4*heSoA*heSoC;
			if (delta < 0)
				out.println("Phương trình vô nghiệm");
			else if (delta == 0)
				out.println("Phương trình có nghiệm kép x1 = x2 = " + (-heSoB / (2 * heSoA)));
			else {
				out.println("Phương trình có 2 nghiệm phân biệt:  ");
				out.println("x1 = " + ((-heSoB - Math.sqrt(delta)) / (2 * heSoA)));
				out.println("x2 = " + ((-heSoB + Math.sqrt(delta)) / (2 * heSoA)));
			}
		}
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Sơn");
//		list.add("Hưng");
//		list.add("Thien");
//		list.add("Hieu");
//		request.setAttribute("a", list);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

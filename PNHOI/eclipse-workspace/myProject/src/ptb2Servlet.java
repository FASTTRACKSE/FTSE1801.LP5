

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ptb2Servlet
 */
public class ptb2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ptb2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!request.getParameter("soA").equals("") && !request.getParameter("soB").equals("") && !request.getParameter("soC").equals("")) {
			int a = Integer.parseInt(request.getParameter("soA"));
			int b = Integer.parseInt(request.getParameter("soB"));
			int c = Integer.parseInt(request.getParameter("soC"));
			double dt = b*b - 4*a*c;
			double nghiem = 0;
			if(a==0){
				if((b == 0) && (c == 0)){
					request.setAttribute("ketQua", "Phuong trinh co vo so nghiem");
				}
				else if((b == 0) && (c != 0)){
					request.setAttribute("ketQua", "Phuong trinh vo nghiem");
				}
				else{
					nghiem = -c/b;
					request.setAttribute("ketQua", "phuong trinh co nghiem la: " + nghiem);
				}
			}else if(dt< 0){
				request.setAttribute("ketQua", "Phuong trinh vo nghiem");
			}else if(dt == 0){
				nghiem = -b/(2*a);
				request.setAttribute("ketQua", "phuong trinh co nghiem kep la: " + nghiem);
			} else{
				request.setAttribute("ketQua", "Phương trình có hai nghiệm phân biệt là: x = " + (-b + Math.sqrt(dt))/(2*a) + " và " + (-b - Math.sqrt(dt))/(2*a));
			}
		}else {
			request.setAttribute("ketQua", "Không được để trống");
		}
		
		
		request.getRequestDispatcher("GiaiPtb2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

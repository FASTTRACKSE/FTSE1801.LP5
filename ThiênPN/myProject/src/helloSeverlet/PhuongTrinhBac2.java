package helloSeverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PhuongTrinhBac2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
     public PhuongTrinhBac2() {
    	 super();
		// TODO Auto-generated constructor stub
    	
	}
     /**
 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 	 */
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	  double soA = Double.parseDouble(request.getParameter("a"));
 	 double soB = Double.parseDouble(request.getParameter("b"));
 	double soC = Double.parseDouble(request.getParameter("c"));
 	// double delta = Math.pow(soB,2)-4*soA*soC;
 	 request.setAttribute("soA", soA);
 	request.setAttribute("soB", soB);
 	request.setAttribute("soC", soC);
// 	 double ketQua= 0;
// 	 
// 	 if(soA == 0) {
// 		 String bac1 = "Phương Trình Bậc nhất";
// 		 request.setAttribute("tenPt", bac1);
// 		 if(soB == 0) {
// 			 if(soC == 0) {
// 				 String voSo = "Phương Trình Vô Số Nghiêm";
// 				 request.setAttribute("tenPt", voSo);
// 			 }else {
// 				 String voN = "Phương Trình Vô Nghiệm";
// 				 request.setAttribute("tenPt", voN);
// 			 }
// 		 }else {
// 			 ketQua = -soC/soB;
// 			 request.setAttribute("tenPt","phương trình có 1 nghiệm"+ ketQua );
// 		 }
// 		 request.getRequestDispatcher("phuongtrinhbac2.jsp").forward(request, response);
// 	 }else {
// 		 String bac2 = "Phương Trình bậc 2";
// 		 request.setAttribute("tenPt", bac2);
// 		 if(delta<0){
// 			String voSo = "Phương Trình Vô Số Nghiêm";
//			 request.setAttribute("tenPt", voSo);
//		   }
//		   else if(delta==0) {
//			   ketQua = -soB/(2*soA);
//			   request.setAttribute("tenPt","Phương Trình có nghiệm kép"+ketQua );	   
//		   }
//		   else {
//			 double  ketQua1 = (-soB + Math.sqrt(delta))/2;
//			 double   ketQua2 = (-soB - Math.sqrt(delta))/2;
//			   request.setAttribute("tenPt","phương trình có 2 nghiệm phân biệt"+ketQua1+"và"+ ketQua2 );
//		   }
 		 request.getRequestDispatcher("phuongtrinhbac2.jsp").forward(request, response);
 	 
 	
 	}
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

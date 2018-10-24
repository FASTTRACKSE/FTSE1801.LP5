package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SinhVienDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		if (name!=null && pass!=null ) {
        	if (name.equals("hung") && pass.equals("123")) {
        		session.setAttribute("user", name);
        		String url = "SinhVienServlet";
        		if (request.getParameter("nameUrl") != null && !request.getParameter("nameUrl").equals("/QuanLySinhVien2/login.jsp?null")) {
        			url = request.getParameter("nameUrl");
        		}
        		response.sendRedirect(url);
//        		response.sendRedirect(request.getContextPath() + "/SinhVienServlet");
        	} else {
            	out.println("Sai tai khoan hoac mat khau");
			}
        } else {
        	out.println("Chưa nhập");
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

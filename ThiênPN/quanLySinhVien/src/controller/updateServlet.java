package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	SinhVienDAO sinhVienDao = new SinhVienDAO();
	if(request.getParameter("edit")== null) {
		SinhVien sinhVien = sinhVienDao.SinhVienByMa(request.getParameter("maSV"));
		request.setAttribute("sinhVien", sinhVien);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}else {
		sinhVienDao.updateSV(request.getParameter("maSV"),request.getParameter("tenSV"),request.getParameter("passSV"));
		sinhVienDao.UpdateDiemSV(request.getParameter("maSV"),request.getParameter("MonHoc"),Integer.parseInt(request.getParameter("diem")));
		response.sendRedirect("http://localhost:8080/quanLySinhVien/QLSinhVienServlet");
	
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

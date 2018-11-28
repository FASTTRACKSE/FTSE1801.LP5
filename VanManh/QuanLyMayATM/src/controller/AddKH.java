package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.KhachHangDAO;
import model.dao.PhuongQuanDAO;
import model.dao.TheAtmDAO;
import model.entity.KhachHang;

/**
 * Servlet implementation class AddKH
 */
public class AddKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		PhuongQuanDAO phuongQuanDAO = new PhuongQuanDAO();
		TheAtmDAO theAtmDAO = new TheAtmDAO();
		KhachHang khachHang = new KhachHang();
		khachHang.setTenKH(request.getParameter("TenKH"));
		khachHang.setDiaChi(request.getParameter("DiaChi"));
		khachHang.setPhuong(request.getParameter("phuong"));
		khachHang.setSoCMND(request.getParameter("SoCMND"));
		khachHang.setEmail(request.getParameter("Email"));
		khachHang.setSoDT(request.getParameter("SoDT"));
		khachHang.setSoTheATM(request.getParameter("soThe"));
		khachHang.setSoTienTrongTK(request.getParameter("Tien"));
		if (khachHangDAO.addKhachHang(khachHang, phuongQuanDAO.layThongTinMaPhuong(khachHang.getPhuong()))) {
			theAtmDAO.addTheATM(theAtmDAO.layThongTinTheATM().getSoTheATM(), theAtmDAO.layThongTinTheATM().getSoTK());
		}
		response.sendRedirect(request.getContextPath() + "/KhachHangServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

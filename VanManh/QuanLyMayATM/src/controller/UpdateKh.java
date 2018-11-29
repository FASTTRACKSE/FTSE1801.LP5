package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.KhachHangDAO;
import model.dao.PhuongQuanDAO;
import model.entity.KhachHang;

/**
 * Servlet implementation class UpdateKh
 */
public class UpdateKh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PhuongQuanDAO phuongQuanDAO = new PhuongQuanDAO();
	KhachHangDAO khachHangDAO = new KhachHangDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("luaChon") == null) {
			KhachHang khachHang = khachHangDAO.showKhachHangTheoMaKH(request.getParameter("MaKH"));
			ArrayList<String> listPhuong = phuongQuanDAO.showDanhSachPhuong("Thanh Khê");
			request.setAttribute("phuong", listPhuong);
			request.setAttribute("KhachHang", khachHang);
			request.getRequestDispatcher("SuaThongTinKh.jsp").forward(request, response);
		}else {
			KhachHang khachHang = new KhachHang();
			khachHang.setTenKH(request.getParameter("TenKH"));
			khachHang.setDiaChi(request.getParameter("DiaChi"));
			khachHang.setSoCMND(request.getParameter("SoCMND"));
			khachHang.setEmail(request.getParameter("Email"));
			khachHang.setSoDT(request.getParameter("SoDT"));
			khachHangDAO.updateKhachHang(request.getParameter("maKH"), khachHang, phuongQuanDAO.layThongTinMaPhuong(request.getParameter("phuong")));
			response.sendRedirect(request.getContextPath() + "/KhachHangServlet");
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

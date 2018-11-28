package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QLSinhVienDAO;

public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteUserServlet() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();
		sinhVienDAO.deleteSinhVienByMaSV(id);
		resp.sendRedirect(req.getContextPath() + "/SinhVienServlet");
	}
}

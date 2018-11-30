package id.impl;

import java.util.ArrayList;

import di.ShowList;
import model.QLSinhVienDAO;
import model.entity.SinhVien;

public class SinhVienImp implements ShowList {

	@Override
	public ArrayList<SinhVien> list() {
		QLSinhVienDAO sinhVienDAO = new QLSinhVienDAO();
		ArrayList<SinhVien> list = sinhVienDAO.displayAllSinhVien();
		return list;
	}

}

package id.impl;

import java.util.ArrayList;

import di.ListSv;
import model.SinhVienDAO;
import model.entity.SinhVien;

public class showListImp implements ListSv {

	@Override
	public ArrayList<SinhVien> listSv() {
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		ArrayList<SinhVien> list = sinhVienDAO.getAllSinhVien();
		return list;
	}
	
}

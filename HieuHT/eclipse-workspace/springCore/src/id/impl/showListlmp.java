package id.impl;

import java.util.ArrayList;

import di.showList;

import demo.SinhVienDao;

public class showListlmp implements showList{

	@Override
	public ArrayList<SinhVien> listSV() {
		SinhVienDao dao = new SinhVienDao();
		ArrayList<SinhVien> list = dao.getAllSinhVien();
		return list;
	}
}

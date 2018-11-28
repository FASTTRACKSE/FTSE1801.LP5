package id.impl;

import java.util.ArrayList;

import di.ShowList;
import model.entity.SinhVien;

public class SinhVienTayImp implements ShowList {

	@Override
	public ArrayList<SinhVien> list() {
		ArrayList<SinhVien> list = new ArrayList<>();
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMASV("1");
		sinhVien.setNAME("Nguyễn Văn A");
		sinhVien.setAGE(21);
		list.add(sinhVien);
		return list;
	}

}

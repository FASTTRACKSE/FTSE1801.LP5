package di.impl;

import java.util.ArrayList;
import java.util.List;

import di.SinhVienITF;
import di.SinhVienInjector;
import model.entity.SinhVien;

public class SinhVienIJT implements SinhVienInjector{
	private SinhVienITF sinhVienITF;
	@Override
	public void setSinhVienITF(SinhVienITF sinhVienITF) {
		this.sinhVienITF = sinhVienITF;
	}

	@Override
	public void hienThi() {
		List<SinhVien> listSV =new  ArrayList<SinhVien>();
		listSV = sinhVienITF.getAllSV();
		for (int i = 0; i < listSV.size(); i++) {
			System.out.println(listSV.get(i).getName());
			System.out.println(listSV.get(i).getAge());
			System.out.println();
		}
	}

}

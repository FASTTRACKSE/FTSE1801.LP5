package di.impl;

import java.util.ArrayList;
import java.util.List;

import di.DaoInjector;
import di.ITFDao;
import di.SinhVienITF;
import model.entity.SinhVien;

public class DemoSV implements SinhVienITF,DaoInjector{
	private ITFDao itfDao;
	@Override
	public void setITFDao(ITFDao itfDao) {
		this.itfDao = itfDao;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> getAllSV() {
			ArrayList<SinhVien> listSV = new ArrayList<>();
			SinhVien sinhVien = new SinhVien();
			sinhVien.setName("manh");
			sinhVien.setAge("21");
			listSV.add(sinhVien);
			sinhVien = new SinhVien();
			sinhVien.setName("luan");
			sinhVien.setAge("23");
			listSV.add(sinhVien);
		return listSV;
	}

}

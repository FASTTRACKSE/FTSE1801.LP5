package model.dao;

import java.util.ArrayList;

import model.entity.SinhVien;

public class SinhVienDao {
	public ArrayList<SinhVien> getSinhVien() {
		SinhVien sinhVien;
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		sinhVien = new SinhVien("Hưng", "30", "1801", "DN");
		list.add(sinhVien);
		sinhVien = new SinhVien("Sơn", "24", "1801", "DN");
		list.add(sinhVien);
		sinhVien = new SinhVien("Thiên", "23", "1801", "DN");
		list.add(sinhVien);
		sinhVien = new SinhVien("Hiêu", "21", "1801", "DN");
		list.add(sinhVien);

		return list;
	}
}

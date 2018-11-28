package di.ipml;

import java.util.ArrayList;

import bean.SinhVien;
import di.ListSinhVien;

public class ShowSinhVienIpml2 implements ListSinhVien {

	@Override
	public ArrayList<SinhVien> list() {
		ArrayList<SinhVien> list = new ArrayList<>();
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMaSV("1");
		sinhVien.setTenSV("luan");
		list.add(sinhVien);
		sinhVien = new SinhVien();
		sinhVien.setMaSV("2");
		sinhVien.setTenSV("manh");
		list.add(sinhVien);
		return list;
	}

}

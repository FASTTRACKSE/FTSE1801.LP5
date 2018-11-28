package di.ipml;

import java.util.ArrayList;

import bean.SinhVien;
import di.ListSinhVien;
import di.SinhVienClient;

public class ShowSinhVienClient implements SinhVienClient {
	private ListSinhVien listSinhVien;
	@Override
	public void setListSinhVien(ListSinhVien listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	@Override
	public void hienThi() {
		ArrayList<SinhVien> list = listSinhVien.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getMaSV());
			System.out.println(list.get(i).getTenSV());
			System.out.println("-----------------");
		}
	}

}

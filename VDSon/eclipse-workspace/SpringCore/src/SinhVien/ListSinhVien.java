package SinhVien;

import java.util.List;

public class ListSinhVien {
	private List<SinhVienFPT> listSinhVien;

	public ListSinhVien(List<SinhVienFPT> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public void show() {
		for (SinhVienFPT sv : listSinhVien) {
			sv.xuat();
		}
	}
}

package di.impl;

import java.util.List;

public class ListSinhVien {
	private List<SinhVienFPT> listSv;

	public ListSinhVien(List<SinhVienFPT> listSv) {
		super();
		this.listSv = listSv;
	}
	public void xuat() {
		for(SinhVienFPT sinhVienFPT : listSv) {
			sinhVienFPT.xuat();
		}
	}

}

package model.entity;

import java.util.List;

public class ListSinhVienFpt {
	private List<SinhVienFpt> sinhVienFpt;

	public ListSinhVienFpt(List<SinhVienFpt> sinhVienFpt) {
		this.sinhVienFpt = sinhVienFpt;
	}
	
	public void xuat() {
		for (SinhVienFpt sinhVienFpt: sinhVienFpt) {
			sinhVienFpt.xuat();
		}
	}
	
}

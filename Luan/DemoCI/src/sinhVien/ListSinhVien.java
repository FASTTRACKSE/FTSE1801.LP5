package sinhVien;

import java.util.List;

public class ListSinhVien {
	private List<SinhVien> list;

	public ListSinhVien(List<SinhVien> list) {
		this.list = list;
	}
	
	public void xuat() {
		for(SinhVien sv:list) {
			sv.xuat();
		}
	}
}

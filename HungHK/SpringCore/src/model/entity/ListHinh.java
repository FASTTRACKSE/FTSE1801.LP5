package model.entity;

import java.util.List;

public class ListHinh {
	private List<Hinh> hinh;
	public ListHinh(List<Hinh> hinh) {
		this.hinh = hinh;
	}
	
	public void xuat() {
		for (Hinh hinh: hinh) {
			hinh.xuat();
		}
	}
	
}

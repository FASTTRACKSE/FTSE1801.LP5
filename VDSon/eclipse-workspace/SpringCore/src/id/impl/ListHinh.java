package id.impl;

import java.util.List;

public class ListHinh {
	private List<Hinh> list;

	public ListHinh(List<Hinh> list) {
		this.list = list;
	}
	
	public void show() {
		for (Hinh h : list) {
			h.xuat();
		}
	}
}

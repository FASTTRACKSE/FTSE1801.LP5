package demoPolymorphism;

import java.util.List;

public class ListHinh {
	private List<Hinh> list;

	public ListHinh(List<Hinh> list) {
		this.list = list;
	}
	public void xuat() {
		for(Hinh h: list) {
			h.xuat();
		}
	}
}

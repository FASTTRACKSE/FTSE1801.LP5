package bean;

import java.util.List;

public class ListHinh {
	private List<AllHinh> list;

	public ListHinh(List<AllHinh> list) {
		this.list = list;
	}
	public void xuat() {
		for(AllHinh li:list) {
			li.xuat();
		}
	}
	
}

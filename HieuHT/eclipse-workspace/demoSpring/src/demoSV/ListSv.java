package demoSV;

import java.util.List;

public class ListSv {
	private List<SinhVienFPT> list;

	public ListSv(List<SinhVienFPT> sinhvienFPT) {
		this.list = sinhvienFPT;
	}
	public void xuat() {
		for(SinhVienFPT Sv: list) {
			Sv.xuat();
		}
	}
}

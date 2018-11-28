package sinhvien;

import java.util.List;

public class ListSinhVien {
	private List<SinhVienFpt> list;
	
	public ListSinhVien() {};
	
	public ListSinhVien(List<SinhVienFpt> list) {
		this.list = list;
	}

	public List<SinhVienFpt> getList() {
		return list;
	}

	public void setList(List<SinhVienFpt> list) {
		this.list = list;
	}
	
	public void xuat() {
		for(SinhVienFpt st: list) {
			st.xuat();
		}
	}
}

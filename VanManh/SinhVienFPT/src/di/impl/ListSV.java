package di.impl;

import java.util.List;

import di.SinhVienFPT;

public class ListSV {
	private List<SinhVienFPT> myList;

	public List<SinhVienFPT> getMyList() {
		return myList;
	}

	public void setMyList(List<SinhVienFPT> myList) {
		this.myList = myList;
	}
	
	public ListSV() {
	}
	public ListSV(List<SinhVienFPT> myList) {
		super();
		this.myList = myList;
	}

	public void hienThi() {
		for (int i = 0; i < myList.size(); i++) {
			myList.get(i).xuat();
		}
	}
}

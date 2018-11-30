package id.impl;

import java.util.ArrayList;

import di.ShowList;
import di.ShowlistClient;
import model.entity.SinhVien;

public class SinhVienClient implements ShowlistClient {
	ShowList showList;
	@Override
	public void setShowlist(ShowList showList) {
		this.showList = showList;
		
	}

	@Override
	public void xuat() {
		ArrayList<SinhVien> myList = showList.list();
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i).getMASV());
			System.out.println(myList.get(i).getNAME());
			System.out.println(myList.get(i).getAGE());
		}
	}

}

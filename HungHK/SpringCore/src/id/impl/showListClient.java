package id.impl;

import java.util.ArrayList;

import di.ListSv;
import di.ListSvClient;
import model.entity.SinhVien;

public class showListClient implements ListSvClient {
	private ListSv listSv;

	@Override
	public void setShowList(ListSv listSv) {
		this.listSv = listSv;
		
	}

	@Override
	public void show() {
		ArrayList<SinhVien> myList = listSv.listSv();
		System.out.printf("%-7s %-12s %-7s\n", "MaSv", "Tên", "Tuổi");
		for (int i=0; i<myList.size(); i++) {
			System.out.printf("%-7s %-12s %-7s\n", myList.get(i).getMaSv(), myList.get(i).getName(), myList.get(i).getAge());
		}
	}
	
}

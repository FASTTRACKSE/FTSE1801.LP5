package Demo.service;

import java.util.ArrayList;

import Demo.di.ShowList;

public class SinhVien implements ShowList{

	@Override
	public ArrayList<String> showList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hoi 1");
		list.add("Hoi 2");
		list.add("Hoi 3");
		return list;
	}

}

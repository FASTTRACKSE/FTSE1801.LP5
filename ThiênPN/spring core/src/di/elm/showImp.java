package di.elm;

import java.util.ArrayList;

import di.showList;
import di.showListData;

public class showImp implements showList{

	@Override
	public ArrayList<SinhVien> listSV() {
		ArrayList<SinhVien>list = new ArrayList<SinhVien>();
		SinhVien sv = new SinhVien();
		sv.setMaSinhVien("11");
		sv.setTensinhVien("aaa");
		list.add(sv);
	
		return list;
	}

	

}

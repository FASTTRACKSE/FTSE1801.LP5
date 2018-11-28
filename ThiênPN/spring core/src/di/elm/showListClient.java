package di.elm;

import java.util.ArrayList;

import di.showList;
import di.showListData;

public class showListClient implements showListData{
    private showList showList;

	@Override
	public void setShowList(showList showList) {
		this.showList = showList;
		
	}

	@Override
	public void show() {
		ArrayList<SinhVien> myList = showList.listSV();
	 for(int i = 0;i<myList.size();i++) {
		 System.out.println(myList.get(i).getMaSinhVien());
		 System.out.println(myList.get(i).getTensinhVien());
		 System.out.println(myList.get(i).getPassword());
		 System.out.println(myList.get(i).getTuoi());
		 System.out.println(myList.get(i).getDiem().getMonHoc());
		 System.out.println(myList.get(i).getDiem().getDiem());
	 }
		
	}
	

}

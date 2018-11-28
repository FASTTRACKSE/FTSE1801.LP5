package Demo.service;

import Demo.di.ShowList;
import Demo.di.ShowListClient;

public class SinhVienDataClient implements ShowListClient{
	private ShowList showlist;
	@Override
	public void setShowList(ShowList showList) {
		this.showlist = showList;
		
	}

	@Override
	public void Show() {
		for(int i = 0; i < showlist.showList().size(); i++) {
			System.out.println(showlist.showList().get(i));
		}
		
	}
	
	
}

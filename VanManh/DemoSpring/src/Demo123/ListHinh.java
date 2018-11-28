package Demo123;

import java.util.List;

public class ListHinh {
private List<Hinh> list;
	
	public List<Hinh> getList() {
		return list;
	}
	public void setList(List<Hinh> list) {
		this.list = list;
	}
	
	public void hienThi() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).show();
		}
	}
}

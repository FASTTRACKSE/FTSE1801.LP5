package di.elm;

import java.util.List;

public class ListSinhVien {
  private List<SinhVienFPT> list;

public ListSinhVien(List<SinhVienFPT> list) {
	super();
	this.list = list;
}
  public void display() {
	  for(SinhVienFPT sv:list) {
		  sv.xuat();
	  }
  }
}

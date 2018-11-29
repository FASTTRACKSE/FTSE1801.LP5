package Demo.service;

import java.util.ArrayList;

import Demo.dao.SinhVienDao;
import Demo.di.ShowList;

public class SinhVienData implements ShowList{

	@Override
	public ArrayList<String> showList() {
		SinhVienDao dao = new SinhVienDao();
		ArrayList<String> list = dao.getAllSinhVien();
		return list;
	}

}

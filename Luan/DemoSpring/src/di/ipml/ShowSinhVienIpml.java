package di.ipml;

import java.util.ArrayList;

import bean.SinhVien;
import dao.SinhVienDao;
import di.ListSinhVien;

public class ShowSinhVienIpml implements ListSinhVien{
	SinhVienDao dao;
	@Override
	public ArrayList<SinhVien> list() {
		dao = new SinhVienDao();
		ArrayList<SinhVien> list = new ArrayList<>();
		list = dao.ShowAllSinhVien();
		return list;
	}
	
}

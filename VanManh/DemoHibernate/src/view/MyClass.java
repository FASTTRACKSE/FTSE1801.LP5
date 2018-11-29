package view;

import java.util.List;

import dao.SinhVienDao;
import entity.SinhVien;

public class MyClass {
	public static void main(String[] args) {
	SinhVienDao sinhVienDao = new SinhVienDao();
		List<SinhVien> list = sinhVienDao.getSinhVienList();
		for (SinhVien sinhVien : list) {
			System.out.println(sinhVien);
		}
//		SinhVien sv = new SinhVien();
//		sv.setName("Nam");
//		sv.setAge("21");
//		sv.setImg("kkkkkkk");
//		sinhVienDao.insertEmployee(sv);
		
		
//		SinhVien sv=sinhVienDao.getEmployeeById(22);
//		sv.setName("lllllllllllll");
//		sinhVienDao.EditEmployee(sv);
		
//		SinhVien sv=sinhVienDao.getEmployeeById(14);
//		sinhVienDao.deleteEmployee(sv);
//		
//		System.out.println("-----------------------------------------------------");
//		list = sinhVienDao.getSinhVienList();
//		for (SinhVien sinhVien : list) {
//			System.out.println(sinhVien);
//		}
	}
}

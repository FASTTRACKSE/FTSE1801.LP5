package view;

import java.util.List;

import dao.SinhVienDao;
import entity.SinhVien;

public class MyClass {
	public static void main(String[] args) {
		SinhVienDao dao = new SinhVienDao(); 
		List<SinhVien> list = dao.getSinhVienList();
		for(SinhVien sv : list) {
			System.out.println(sv);
		}
		
		System.out.println("-------------------------");
		
		dao.insertEmployee(new SinhVien(25,"olala","12","USA"));;
//		dao.deleteEmployee(dao.getEmployeeById(26));
		
		System.out.println("-------------------------");
		
		dao.EditEmployee(new SinhVien(1,"thien","21","QN"));
		
	}
}
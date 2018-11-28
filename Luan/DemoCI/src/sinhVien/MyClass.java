package sinhVien;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sinhVien.xml");
//		SinhVien sinhVien = (SinhVien) context.getBean("sinhVienBiz");
//		sinhVien.xuat();
//		sinhVien = (SinhVien) context.getBean("sinhVienIT");
//		sinhVien.xuat();
		
		ListSinhVien listSinhVien = (ListSinhVien) context.getBean("list");
		listSinhVien.xuat();
	}
	
}

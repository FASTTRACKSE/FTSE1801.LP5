package SinhVien;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSinhVien {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Sinhvien.xml");
		
		ListSinhVien listSinhVien = (ListSinhVien) context.getBean("listSV");
		listSinhVien.show();
	 }
}

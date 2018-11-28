package demoSV;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoPolymorphism.ListHinh;

public class DanhSachSv {
	public static void main(String[] arge) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SV.xml");
		ListSv list = (ListSv) applicationContext.getBean("list");
		list.xuat();
	}
}

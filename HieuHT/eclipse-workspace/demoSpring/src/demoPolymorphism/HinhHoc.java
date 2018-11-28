package demoPolymorphism;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HinhHoc {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//		Hinh hinhCn = (Hinh) applicationContext.getBean("hinhCn");
//			hinhCn.xuat();
//		hinhCn = (Hinh) applicationContext.getBean("hinhV");
//			hinhCn.xuat();
		ListHinh list = (ListHinh) applicationContext.getBean("list");
		list.xuat();
	}
}

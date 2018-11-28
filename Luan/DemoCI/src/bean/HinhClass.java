package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HinhClass {
	
	@SuppressWarnings({ "resource"})
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("allHinh.xml");
//		AllHinh hinh = (AllHinh) context.getBean("chuNhat");
//		hinh.xuat();
//		hinh = (AllHinh) context.getBean("vuong");
//		hinh.xuat();
//		List<AllHinh> list = (List<AllHinh>) context.getBean("list");
//		for(AllHinh h: list) {
//			h.xuat();
//		}
		ListHinh list = (ListHinh) context.getBean("list");
		list.xuat();
	}
}

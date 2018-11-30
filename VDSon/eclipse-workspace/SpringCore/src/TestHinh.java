import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import id.impl.Hinh;
import id.impl.ListHinh;

public class TestHinh {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("hinh.xml");
		Hinh hinh = (Hinh) context.getBean("hinhChuNhat");
		hinh.xuat();
		hinh = (Hinh) context.getBean("hinhVuong");
		hinh.xuat();
		
		ListHinh listHinh = (ListHinh) context.getBean("listHinh");
		listHinh.show();
	}
}

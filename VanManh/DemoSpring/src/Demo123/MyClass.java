package Demo123;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("bean.xml");
		Hinh hinh = (Hinh) context.getBean("hcn");
		hinh.show();
		hinh = (Hinh) context.getBean("hv");
		hinh.show();
		System.out.println("-------------------------------");
		ListHinh myList =  (ListHinh) context.getBean("listHinh");
		myList.hienThi();
	}
}

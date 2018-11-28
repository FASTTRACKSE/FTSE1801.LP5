import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.impl.ListSV;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("bean.xml");
		ListSV listSV = (ListSV) context.getBean("list");
		listSV.hienThi();
	}
}

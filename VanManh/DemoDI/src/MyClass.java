import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.SinhVienInjector;

public class MyClass {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		SinhVienInjector sinhVienInjector = (SinhVienInjector) context.getBean("sinhVien");
		sinhVienInjector.hienThi();
	}
}
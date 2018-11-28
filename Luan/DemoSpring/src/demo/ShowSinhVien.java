package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.SinhVienClient;

public class ShowSinhVien {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		SinhVienClient client = (SinhVienClient) context.getBean("SV");
		client.hienThi();;
	}
}

package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.HinhClient;

public class ClassHinh {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hinh.xml");
		HinhClient hinh = (HinhClient) context.getBean("hinhVuong");
		hinh.xuat();
		hinh = (HinhClient) context.getBean("hinhChuNhat");
		hinh.xuat();
	}
}

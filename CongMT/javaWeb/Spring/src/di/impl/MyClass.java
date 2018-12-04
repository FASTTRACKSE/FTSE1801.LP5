package di.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di1.Greeting;
import di1.GreetingClient;

import di1.ListStudent;
import di1.StudentClient;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		
//		context =  new ClassPathXmlApplicationContext("context.xml");
//		Greeting greeting= (Greeting) context.getBean("greeting");
//		System.out.println(greeting.greet());
//		GreetingClient greetingClientImp = (GreetingClient) context.getBean("greetingClientImp"); 
//		greetingClientImp.setGreeting(new Greeting() {
//			
//			@Override
//			public String greet() {
//				return "Son gay hai voi phu nu";
//			}
//		});
//		greetingClientImp.xuatLoiChao();
		context =  new ClassPathXmlApplicationContext("context.xml");
		
//		StudentClient studentClient = (StudentClient) context.getBean("studentClient"); 
//		studentClient.hienThi();
		
//		Hinh hcn= (Hinh) context.getBean("hinhCN");
//		hcn.xuat();
//		hcn= (Hinh) context.getBean("hinhVuong");
//		hcn.xuat();
//		ListHinh listHinh= (ListHinh) context.getBean("listHinh");
//		listHinh.xuat();
		SinhVienFPT sinhVien = (SinhVienFPT) context.getBean("sinhVienBiz");
		sinhVien.xuat();
		sinhVien= (SinhVienFPT) context.getBean("sinhVienIt");
		sinhVien.xuat();
		
		ListSinhVien listSv = (ListSinhVien) context.getBean("listSv");
		listSv.xuat();
		
		
//		Greeting greeting1 = new EnglishGreetingImp();
//		System.out.println(greeting1.greet());
//		
//		greeting1 = new VietNamGreetingImp();
//		System.out.println(greeting1.greet());
//		
//		System.out.println("--------------------------");
//		greeting1 = new EnglishGreetingImp();
//		GreetingClient greetingClientImp = new GreetingClientImp1();
//		greetingClientImp.setGreeting(greeting1);
//		greetingClientImp.xuatLoiChao();
//		
//		greetingClientImp = new GreetingClientImp2();
//		greetingClientImp.setGreeting(greeting1);
//		greetingClientImp.xuatLoiChao();
//		
//		greeting1 = new VietNamGreetingImp();
//		greetingClientImp.setGreeting(greeting1);
//		greetingClientImp.xuatLoiChao();
//		
//		greetingClientImp = new GreetingClientImp1();
//		greetingClientImp.setGreeting(greeting1);
//		greetingClientImp.xuatLoiChao();
//		
//		greetingClientImp = new GreetingClientImp2();
//		greetingClientImp.setGreeting(new Greeting() {
//			
//			@Override
//			public String greet() {
//				return "Son gay hai voi phu nu";
//			}
//		});
//		greetingClientImp.xuatLoiChao();
		
	}
}

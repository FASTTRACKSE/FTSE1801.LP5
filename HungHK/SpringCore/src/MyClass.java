import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.Greeting;
import di.GreetingClient;
import di.ListSv;
import di.ListSvClient;
import model.entity.Employee;
import model.entity.HinhChuNhat;
import model.entity.HinhVuong;
import model.entity.ListHinh;
import model.entity.ListSinhVienFpt;
import model.entity.Question;
import model.entity.SinhVienBiz;
import model.entity.SinhVienFpt;
import model.entity.SinhVienIT;

public class MyClass {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		
//		Greeting greeting = (Greeting) context.getBean("greeting");
//		System.out.println(greeting.greeting());
//		GreetingClient greetingClient = (GreetingClient) context.getBean("greetingClient");
//		greetingClient.xuatLoiChao();
		
		
//		ListSv listSv = (ListSv) context.getBean("slist");
//		System.out.println(listSv.listSv());
//		ListSvClient listSvClient = (ListSvClient) context.getBean("data");
//		listSvClient.show();
		
//		Employee employee = (Employee) context.getBean("e");
//		employee.show();
//		
//		Question question = (Question) context.getBean("qq");
//		question.displayInfo();
		
//		HinhChuNhat hinhChuNhat = (HinhChuNhat) context.getBean("cn");
//		hinhChuNhat.xuat();
//		
//		hinhChuNhat = (HinhVuong) context.getBean("v");
//		hinhChuNhat.xuat();
		
//		ListHinh listHinh = (ListHinh) context.getBean("h");
//		listHinh.xuat();
		
//		SinhVienFpt sinhVienIT = (SinhVienIT) context.getBean("sv");
//		sinhVienIT.xuat();
		
//		ListSinhVienFpt listSinhVienFpt = (ListSinhVienFpt) context.getBean("svfpt");
//		listSinhVienFpt.xuat();
//		
//		SinhVienFpt sinhVienFpt = new SinhVienBiz("A", "Biz", 6, 7);
//		SinhVienFpt sinhVienFpt2 = new SinhVienIT("B", "IT", 5, 8, 3);
//		List<SinhVienFpt> list = new ArrayList<SinhVienFpt>();
//		list.add(sinhVienFpt);
//		list.add(sinhVienFpt2);
//		ListSinhVienFpt myList = new ListSinhVienFpt(list);
//		myList.xuat();
		
		SinhVienBiz biz = (SinhVienBiz) context.getBean("svbiz");
		biz.xuat();
		
	}
}

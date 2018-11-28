package sinhvien;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context =  new ClassPathXmlApplicationContext("context.xml");
		ListSinhVien sv = (ListSinhVien) context.getBean("listSv");
		sv.xuat();
//		SinhVienFpt fpt = new Biz("A", "biz", 3, 6);
//		List<SinhVienFpt> list = new ArrayList<>();
//		list.add(fpt);
//		ListSinhVien myList = new ListSinhVien(list);
//		myList.xuat();
		
	}
}

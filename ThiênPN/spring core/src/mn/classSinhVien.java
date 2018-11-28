package mn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.elm.ListSinhVien;
import di.elm.SinhVienBiz;
import di.elm.SinhVienFPT;
import di.elm.SinhVienIT;

public class classSinhVien {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("hinh.xml");
		// SinhVienFPT fpt =(SinhVienFPT) context.getBean("fpt");

		SinhVienFPT fpt = (SinhVienBiz) context.getBean("biz");
		// fpt.xuat();
       
		fpt = (SinhVienIT) context.getBean("it");
     
		// fpt.xuat();
		ListSinhVien listSv = (ListSinhVien) context.getBean("list");
		listSv.display();
	}
}

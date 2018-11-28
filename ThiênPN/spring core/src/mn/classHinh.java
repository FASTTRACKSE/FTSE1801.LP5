package mn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.elm.HinhChuNhat;
import di.elm.HinhVuong;

public class classHinh {
	private static ApplicationContext context;
  public static void main(String[] args) {
	  context = new ClassPathXmlApplicationContext("hinh.xml");
	  HinhChuNhat cn =(HinhChuNhat) context.getBean("hcn");
	cn.xuat();
	cn =(HinhVuong) context.getBean("hv1");
    ((HinhVuong) cn).hv();
}
}

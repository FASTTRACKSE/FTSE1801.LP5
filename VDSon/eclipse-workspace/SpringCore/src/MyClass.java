import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.HinhClient;
import di.ShowlistClient;
import id.impl.HinhVuongClient;
import model.entity.Employer;
import model.entity.Employer2;
import model.entity.Employer3;
import model.entity.Question;
import model.entity.Question2;

public class MyClass {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
//		Greeting greeting = (Greeting)context.getBean("greeting");
//		System.out.println(greeting.greeting());
//		
//		GreetingClient greetingClient = (GreetingClient)context.getBean("greetingClient");
//		greetingClient.xuatLoiChao();
		
		ShowlistClient showlistClient = (ShowlistClient) context.getBean("showlistClient");
		showlistClient.xuat();
		
		Employer employer = (Employer) context.getBean("employer");
		employer.show();
		
		Question question = (Question) context.getBean("question");
		question.displayInfo();
		
		Question2 question2 = (Question2) context.getBean("question2");
		question2.displayInfo();
		
		Employer2 employer1 = (Employer2) context.getBean("employer2");
		employer1.show();
		
		Employer3 employer3 = (Employer3) context.getBean("employer3");
		employer3.display();
		
		HinhClient hinhClient = (HinhClient) context.getBean("hinhChuNhat");
		hinhClient.xuat();
		
		HinhVuongClient client = (HinhVuongClient) context.getBean("hinhVuong");
		client.xuat();
	}
}

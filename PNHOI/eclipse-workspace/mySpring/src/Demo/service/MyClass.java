package Demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo.di.ShowList;
import Demo.di.ShowListClient;
import collection.Question;
import collection.Question1;
import constructor.Employee;
import map.Question2;
import inheriting.Employee1;
import setter.SinhVien;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		ShowList showList = (ShowList) context.getBean("list");
		ShowListClient showListClient = (ShowListClient) context.getBean("listClient");
		showListClient.Show();
		
		Employee employee = (Employee) context.getBean("e");
		employee.show();
		
		Question question = (Question) context.getBean("q");
		question.displayInfo();
		
		Question1 question1 = (Question1) context.getBean("q1");
		question1.displayInfo();
		
		Question2 question2 = (Question2) context.getBean("q2");
		question2.displayInfo();
		
		Employee1 employee1= (Employee1) context.getBean("e2");
		employee1.show();
		
		SinhVien sv= (SinhVien) context.getBean("SV");
		sv.show();
		
	}
	
}

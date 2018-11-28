package Demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo.di.ClientLoiChao;
import Demo.di.SendLoiChao;

public class text {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		SendLoiChao send = (SendLoiChao)context.getBean("greeting");
		ClientLoiChao client = (ClientLoiChao) context.getBean("greetingClient");
		client.xuatLoiChao();
	}
}

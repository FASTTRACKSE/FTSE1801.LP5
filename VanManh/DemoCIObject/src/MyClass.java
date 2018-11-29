import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		Employee employee = (Employee) context.getBean("e");
		employee.show();
	}
}

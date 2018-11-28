package view;

import java.util.List;

import dao.UserDao;
import dao.UserDao2;
import entity.UserBean1;

public class MyClass {
	public static void main(String[] args) {
//		UserDao dao = new UserDao();
//		List<UserBean1> list = dao.getAllUser();
//		for(UserBean1 user: list) {
//			System.out.println(user);
//		}
//		
//		UserBean1 user = new UserBean1();
//		user = dao.getUserById("11");
//		user.setName("Duy Luan");
//		dao.updateUser(user);
////		user.setId("13");
////		user.setName("luan");
////		user.setPass("123141");
////		user.setAge("24");
////		user.setAdd("142ad");
////		dao.addUser(user);
////		
//		
//		list = dao.getAllUser();
//		for(UserBean1 user2: list) {
//			System.out.println(user2);
//		}
////		user = dao.getUserById("13");
////		dao.deleteUser(user);
		
		// EntityManager
		UserDao2 dao2 = new UserDao2();
		List<UserBean1> list = dao2.getAllUser();
		for(UserBean1 user: list) {
			System.out.println(user);
		}
		
	}
}

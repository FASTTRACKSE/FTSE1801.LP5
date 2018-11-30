package model.dao;
import model.entity.User;
public class UserDao {
	public User getUser(String username, String password) {
		//kết nối data
		User user = null;
		if ("son".equals(username) && "123".equals(password)) {
			user  = new User();
			user.setUsername("son");
			user.setPassword("123");
			user.setFullname("Van duc son");
			user.setOld("25");
		}
		return user;
	}
}

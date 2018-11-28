package model.dao;

import model.entity.User;

public class UserDAO {
	public User getUser(String user,String pass) {
		User user1 = null;
		if("Hoi".equals(user) && "123".equals(pass)) {
			user1 = new User();
			user1.setUser("Hoi");
			user1.setPass("123");
		}
		return user1;
	}
}

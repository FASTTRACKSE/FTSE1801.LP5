package model.dao;

import model.entity.User;

public class UserDao {
	public User getUser(String userName, String pass) {
		User user = null;
		if ("manh".equals(userName)&&"123".equals(pass)) {
			user = new User();
			user.setFullName("Vu Van Manh");
		}
		return user;
	}
}

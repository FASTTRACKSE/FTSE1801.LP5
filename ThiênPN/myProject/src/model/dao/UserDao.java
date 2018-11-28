package model.dao;

import model.entity.User;

public class UserDao {
   public User getUser(String username, String password) {
	   User user = null;
	   if("nhat".equals(username) && "123".equals(password)) {
		   user = new User();
		   user.setUsername("naht");
		   user.setPassword("123");
	   }
	   return user;
   }
}

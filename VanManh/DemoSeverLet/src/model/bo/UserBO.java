package model.bo;

import model.dao.UserDao;

public class UserBO {
	UserDao userDao = new UserDao();
	public boolean checkUser(String userName, String pass) {
		return userDao.getUser(userName, pass) != null;
	}
}

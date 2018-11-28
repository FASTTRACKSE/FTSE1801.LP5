package model.bo;

import model.dao.UserDao;

public class UserBo {
	private UserDao userDao = new UserDao();
	public boolean checkExisUser(String username, String password) {
		return userDao.getUser(username, password) != null;
	}
}

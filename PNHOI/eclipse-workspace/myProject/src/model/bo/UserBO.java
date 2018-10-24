package model.bo;

import model.dao.UserDAO;

public class UserBO {
	private UserDAO userDAO;
	public boolean checkExistUser(String user, String pass) {
		return userDAO.getUser(user, pass) != null;
	}
}

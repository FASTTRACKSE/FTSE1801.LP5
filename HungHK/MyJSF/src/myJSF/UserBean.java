package myJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.dao.UserDao;

@ManagedBean
public class UserBean {
	private int id;
	private String username = "Hưng";
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String sayHello() {
		username = userDao.getUsername(id);
		return "xinchao";
	}
	

}

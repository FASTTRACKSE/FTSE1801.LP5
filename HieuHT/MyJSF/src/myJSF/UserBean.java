package myJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.UserDao;

@ManagedBean
public class UserBean {
	private String username;
	private int id;
	@ManagedProperty(value="#{userDao}")
	private UserDao userDao;
	
	public String getUsername() {
		return username;
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
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String sayHelloUser() {
		username = userDao.getUsername(id);
		return"xinchao";
	}
}

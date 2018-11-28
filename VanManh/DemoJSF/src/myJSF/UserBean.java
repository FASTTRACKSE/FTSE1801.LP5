package myJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Dao.UserDao;

@ManagedBean
public class UserBean {
	@ManagedProperty(value="#{userDao}")
	private UserDao userDao;
	private String userName;
	private int id;

	public int getId() {
		return id;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String sayHelloUser() {
			userName = userDao.getName(id);
		return "hello";
	}
	
}

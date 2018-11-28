package myJSF;
import javax.faces.bean.*;

import model.dao.UserDao;
@ManagedBean
public class UserBean {
	private int id;
	private String userName="Công";
@ManagedProperty(value="#{userDao}")
private UserDao userDao;

	public String getUserName() {
		return userName;
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

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String sayHelloUser() {
		System.out.println(userName);
		return "welcome";
	}
}

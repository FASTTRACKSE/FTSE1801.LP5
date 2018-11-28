package myJFS;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javafx.beans.DefaultProperty;
import model.UserDao;

@ManagedBean(name="ten")
public class UserBean {
	private String userName;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManagedProperty(value="#{dao}")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String sayHello() {
		userName = userDao.getUserName(id);
		return "XinChao";
	}
	
}

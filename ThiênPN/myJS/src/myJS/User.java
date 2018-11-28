package myJS;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import userDao.UserDao;;

@ManagedBean
public class User {
	private int id;
	private String UserName;
	@ManagedProperty(value="#{userDao}")
    private UserDao userDao;
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
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

	public String sayHelloUser() {
		UserName=userDao.getUsername(id);
		return "xinchao";
	}
}

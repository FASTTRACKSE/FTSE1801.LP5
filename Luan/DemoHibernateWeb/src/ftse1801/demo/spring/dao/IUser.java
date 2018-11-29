package ftse1801.demo.spring.dao;

import java.util.ArrayList;

import ftse1801.demo.spring.bean.User;

public interface IUser {
	public ArrayList<User> showAllUser();
	public ArrayList<User> showAllUserInPage(int start, int recordPage);
	public boolean addUser(String id, String name, String pass, String age, String add, String img);
	public boolean updateUser(String name, String pass, String age, String add, String id, String img);
	public boolean delUser(String id);
	public User getUser(String id);
}

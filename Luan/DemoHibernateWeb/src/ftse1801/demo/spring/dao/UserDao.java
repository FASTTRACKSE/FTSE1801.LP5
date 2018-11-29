package ftse1801.demo.spring.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate4.HibernateTemplate;

import ftse1801.demo.spring.bean.User;

public class UserDao implements IUser{
	@Override
	public ArrayList<User> showAllUser() {
		
		
		
		return null;
	}

	@Override
	public ArrayList<User> showAllUserInPage(int start, int recordPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(String id, String name, String pass, String age, String add, String img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(String name, String pass, String age, String add, String id, String img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

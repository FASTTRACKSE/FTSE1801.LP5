package ftse1801.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.dao.UserDao;
import ftse1801.demo.di.IUserService;
import ftse1801.demo.entity.User;

public class UserService implements IUserService{
	private UserDao dao;
	@Override
	@Transactional
	public List<User> showAllUser() {
		return dao.showAllUser();
	}

	@Override
	public List<User> showAllUserInPage(int start, int recordPage) {
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

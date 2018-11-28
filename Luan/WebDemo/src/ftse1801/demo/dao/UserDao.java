package ftse1801.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ftse1801.demo.di.IUserDao;
import ftse1801.demo.entity.User;

public class UserDao implements IUserDao {
	@SuppressWarnings("unused")
	private EntityManager entityManagerFactory;
	@PersistenceContext
	private EntityManager manager;
	@SuppressWarnings("unchecked")
	@Override
	public List<User> showAllUser() {
		List<User> list =  manager.createQuery("from UserBean1").getResultList();
		return list;
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

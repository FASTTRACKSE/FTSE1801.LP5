package ftse1801.demo.spring.modal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.spring.di.IUserDao;
import ftse1801.demo.spring.modal.bean.User;

public class UserDaoJPA implements IUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> showAllUser() {
		List<User> list = entityManager.createQuery("from User").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> showAllUserInPage(int start, int recordPage) {
		Query query = entityManager.createQuery("from User");
		if (start != 0)
			query.setFirstResult(start);
		if (recordPage != 0)
			query.setMaxResults(recordPage);
		return (List<User>) query.getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addUser(String id, String name, String pass, String age, String add, String img) {
		boolean kiemTra = false;
		User user = new User(id, name, pass, age, add, img);
		if (!entityManager.contains(user)) {
			entityManager.persist(user);
			entityManager.flush();
			kiemTra = true;
		}
		
		entityManager.close();
		return kiemTra;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean updateUser(String name, String pass, String age, String add, String id, String img) {
		boolean kiemTra = false;
		User user = new User(id, name, pass, age, add, img);
		if (!entityManager.contains(user)) {
			entityManager.merge(user);
			entityManager.flush();
			kiemTra = true;
		}
		return kiemTra;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean delUser(String id) {
		boolean kiemTra = false;
		User user = getUser(id);
		if (entityManager.contains(user)) {
			entityManager.remove(user);
			entityManager.flush();
			kiemTra = true;
		}
		return kiemTra;
	}

	@Override
	public User getUser(String id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

}

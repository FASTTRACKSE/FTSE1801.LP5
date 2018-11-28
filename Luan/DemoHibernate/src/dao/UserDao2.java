package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.UserBean1;

public class UserDao2 {

	@SuppressWarnings({ "unchecked"})
	public List<UserBean1> getAllUser() {
		EntityManager manager = null;
		List<UserBean1> list = null;
			manager = HibernateAPIUtil.getEntityManager();
			list = manager.createQuery("from UserBean1").getResultList();
		return list;
	}

//	@SuppressWarnings("unused")
//	public UserBean1 getUserById(String id) {
//		manager manager = null;
//		UserBean1 user = null;
//		try {
//			manager = HibernateUtil.getmanager();
//			String queryStr = "select user from UserBean1 user";
//			user = manager.get(UserBean1.class, id);
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// handle exception here
//		} finally {
//			try {
//				if (manager != null)
//					manager.close();
//			} catch (Exception ex) {
//			}
//		}
//		return user;
//	}
//
//	public void addUser(UserBean1 user) {
//		manager manager = null;
//		Transaction transaction = null;
//		try {
//			manager = HibernateUtil.getmanager();
//			transaction = manager.beginTransaction();
//			manager.save(user);
//			transaction.commit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// handle exception here
//			if (transaction != null)
//				transaction.rollback();
//		} finally {
//			try {
//				if (manager != null)
//					manager.close();
//			} catch (Exception ex) {
//			}
//		}
//	}
//
//	public void updateUser(UserBean1 user) {
//		manager manager = null;
//		Transaction transaction = null;
//		try {
//			manager = HibernateUtil.getmanager();
//			transaction = manager.beginTransaction();
//			manager.update(user);
//			transaction.commit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// handle exception here
//			if (transaction != null)
//				transaction.rollback();
//		} finally {
//			try {
//				if (manager != null)
//					manager.close();
//			} catch (Exception ex) {
//			}
//		}
//
//	}
//
//	public void deleteUser(UserBean1 user) {
//		manager manager = null;
//		Transaction transaction = null;
//		try {
//			manager = HibernateUtil.getmanager();
//			transaction = manager.beginTransaction();
//			manager.delete(user);
//			transaction.commit();
//			System.out.println("deleted employee: " + user.getName());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// handle exception here
//			if (transaction != null)
//				transaction.rollback();
//		} finally {
//			try {
//				if (manager != null)
//					manager.close();
//			} catch (Exception ex) {
//			}
//		}
//	}

}

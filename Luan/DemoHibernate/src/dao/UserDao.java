package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.UserBean1;

public class UserDao {

	@SuppressWarnings({ "unchecked"})
	public List<UserBean1> getAllUser() {
		Session session = null;
		List<UserBean1> list = null;
		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(UserBean1.class);
//			list = session.createQuery("from UserBean1").list();
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return list;
	}

	@SuppressWarnings("unused")
	public UserBean1 getUserById(String id) {
		Session session = null;
		UserBean1 user = null;
		try {
			session = HibernateUtil.getSession();
			String queryStr = "select user from UserBean1 user";
			user = session.get(UserBean1.class, id);

		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return user;
	}

	public void addUser(UserBean1 user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

	public void updateUser(UserBean1 user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}

	}

	public void deleteUser(UserBean1 user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			System.out.println("deleted employee: " + user.getName());
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

}

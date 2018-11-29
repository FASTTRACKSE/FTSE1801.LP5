package demoHibernate.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import demoHibernate.model.entity.SinhVien;

public class SinhVienDao {
	@SuppressWarnings("unchecked")
	public List<SinhVien> getSinhVienList() {
		Session session = null;
		List<SinhVien> list = null;
		try {
			session = SinhVienUtil.getSession();
			String queryStr = "from SinhVien";
			Query query = session.createQuery(queryStr);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e) {

			}
		}
		return list;
	}

	@SuppressWarnings("unused")
	public SinhVien getEmployeeById(int id) {

		Session session = null;
		SinhVien sv = null;
		try {
			session = SinhVienUtil.getSession();
			String queryStr = "chọn sv từ SinhVien sv";
			sv = session.get(SinhVien.class, id);
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
		return sv;
	}

	public void insertEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			session.save(sv);
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

	public void deleteEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(sv);
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

	public void EditEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			session.update(sv);
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
}
package sinhvien.model.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import sinhvien.model.entity.SinhVien;

public class HibernateDAO implements ISinhVienDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFatory(SessionFactory session) {
		this.sessionFactory = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public boolean deleteSinhVien(String id) {
		Session session = null;
		SinhVien sv = null;
		boolean check = false;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			sv = session.load(SinhVien.class, id);
			session.delete(sv);
			session.getTransaction().commit();
			check = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return check;
	}

	@Override
	public boolean addNewSinhVien(SinhVien sinhvien) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.save(sinhvien);
			transaction.commit();
			check = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return check;
	}

	@Override
	public boolean updateSinhVien(SinhVien sinhvien, String id) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.update(sinhvien);
			transaction.commit();
			check = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return check;
	}

	@SuppressWarnings("unused")
	@Override
	public SinhVien getSinhVien(String id) {
		Transaction transaction = null;
		Session session = null;
		SinhVien sv = null;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			sv = (SinhVien) session.get(SinhVien.class, id);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return sv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAll(int trang, int soDong) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from SinhVien");
		query.setFirstResult(trang);
		query.setMaxResults(soDong);
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public int getCount(int soDong) {
		return 0;
	}
}

package demo.hibernate.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.hibernate.model.entity.SinhVien;
//import demo.hibernate.model.entity.Diem;
import demo.hibernate.model.entity.SinhVien;

public class SinhVienDao {
	private static SessionFactory factory;
	@SuppressWarnings("unchecked")
	public List<SinhVien> getSinhVienList() {
		Session session = null;
		List<SinhVien> list = null;
		try {
			session = HibernateUtil.getSession();
			String queryStr = "select sv from SinhVien sv";
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
	public SinhVien getSinhVienById(String maSv) {

		Session session = null;
		SinhVien sinhVien = null;
		try {
			session = HibernateUtil.getSession();
			String queryStr = "select sv from SinhVien sv";
			sinhVien = session.get(SinhVien.class, maSv);

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
		return sinhVien;
	}

	public void addSinhVien(SinhVien sinhVien) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(sinhVien);
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
	
	public void updateSinhVien(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
//			sv.setName("67");
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

	public void deleteSinhVien(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
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
	
	

}

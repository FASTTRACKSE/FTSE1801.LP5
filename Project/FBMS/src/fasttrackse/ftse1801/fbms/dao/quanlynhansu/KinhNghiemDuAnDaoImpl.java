package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.KinhNghiemDuAn;

@Repository
public class KinhNghiemDuAnDaoImpl implements KinhNghiemDuAnDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KinhNghiemDuAn> list() {
		Session session = sessionFactory.openSession();
		List<KinhNghiemDuAn> list = session.createQuery("from KinhNghiemDuAn where isdelete = 0").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KinhNghiemDuAn> getByMaNhanVien(int maNhanVien) {
		Session session = sessionFactory.openSession();
		List<KinhNghiemDuAn> list = session
				.createQuery("from KinhNghiemDuAn where isdelete = 0 and ma_nhan_vien = " + maNhanVien).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KinhNghiemDuAn> getByPaging(int fistResult, int maxResult) {
		Session session = sessionFactory.openSession();
		List<KinhNghiemDuAn> list = session.createQuery("from KinhNghiemDuAn where isdelete = 0")
				.setFirstResult(fistResult).setMaxResults(maxResult).list();
		session.close();
		return list;
	}

	@Override
	public void addNew(KinhNghiemDuAn kinhNghiemDuAn) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(kinhNghiemDuAn);
		tx.commit();
		session.close();
	}

	@Override
	public void update(KinhNghiemDuAn kinhNghiemDuAn) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(kinhNghiemDuAn);
		tx.commit();
		session.close();
	}

	@Override
	public KinhNghiemDuAn getById(int id) {
		Session session = sessionFactory.openSession();
		KinhNghiemDuAn kinhNghiemDuAn = session.get(KinhNghiemDuAn.class, id);
		session.close();
		return kinhNghiemDuAn;
	}

}

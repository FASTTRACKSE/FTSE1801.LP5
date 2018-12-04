package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

@Repository
public class ChungChiDaoImpl implements ChungChiDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinChungChi> getAll() {
		Session session = sessionFactory.openSession();
		List<ThongTinChungChi> list = session.createQuery("from ThongTinChungChi").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinChungChi> getByPaging(int fistResult, int maxResult) {
		Session session = sessionFactory.openSession();
		List<ThongTinChungChi> list = session.createQuery("from ThongTinChungChi").setFirstResult(fistResult)
				.setMaxResults(maxResult).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinChungChi> findByMaNhanVien(int maNhanVien) {
		Session session = sessionFactory.openSession();
		List<ThongTinChungChi> list = session.createQuery("from ThongTinChungChi where maNhanVien = " + maNhanVien)
				.list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThongTinChungChi chungChi) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(chungChi);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ThongTinChungChi chungChi) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(chungChi);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(ThongTinChungChi.class, id));
		tx.commit();
		session.close();
	}

}

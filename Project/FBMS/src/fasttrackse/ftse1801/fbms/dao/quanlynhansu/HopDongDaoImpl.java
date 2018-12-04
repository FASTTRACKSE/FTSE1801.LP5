package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HopDong;

@Repository
public class HopDongDaoImpl implements HopDongDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HopDong> getAll() {
		Session session = sessionFactory.openSession();
		List<HopDong> list = session.createQuery("from HopDong").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HopDong> getByPaging(int fistResult, int maxResult) {
		Session session = sessionFactory.openSession();
		List<HopDong> list = session.createQuery("from HopDong").setFirstResult(fistResult).setMaxResults(maxResult).list();
		session.close();
		return list;
	}

	@Override
	public HopDong findByMaNhanVien(int maNhanVien) {
		Session session = sessionFactory.openSession();
		HopDong hopDong = session.get(HopDong.class, maNhanVien);
		session.close();
		return hopDong;
	}

	@Override
	public void addNew(HopDong hopDong) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(hopDong);
		tx.commit();
		session.close();
	}

	@Override
	public void update(HopDong hopDong) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(hopDong);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(HopDong.class, id));
		tx.commit();
		session.close();
	}

}

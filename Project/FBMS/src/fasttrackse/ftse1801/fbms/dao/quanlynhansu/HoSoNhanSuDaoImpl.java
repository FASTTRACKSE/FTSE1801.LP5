package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

@Repository
public class HoSoNhanSuDaoImpl implements HoSoNhanSuDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanSu> getAll() {
		Session session = sessionFactory.openSession();
		List<HoSoNhanSu> list = session.createQuery("from HoSoNhanSu").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanSu> getByPaging(int fistResult, int maxResult) {
		Session session = sessionFactory.openSession();
		List<HoSoNhanSu> list = session.createQuery("from HoSoNhanSu").setFirstResult(fistResult)
				.setMaxResults(maxResult).list();
		session.close();
		return list;
	}

	@Override
	public HoSoNhanSu getById(int id) {
		Session session = sessionFactory.openSession();
		HoSoNhanSu nhanVien = session.get(HoSoNhanSu.class, id);
		session.close();
		return nhanVien;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanSu> getByPhongBan(String maPhongBan) {
		Session session = sessionFactory.openSession();
		List<HoSoNhanSu> list = session.createQuery("from HoSoNhanSu where maPhongBan = "+maPhongBan).list();
		session.close();
		return list;
	}

	@Override
	public void addNew(HoSoNhanSu nhanVien) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(nhanVien);
		tx.commit();
		session.close();
	}

	@Override
	public void update(HoSoNhanSu nhanVien) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(nhanVien);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(HoSoNhanSu.class, id));
		tx.commit();
		session.close();
	}
	
}

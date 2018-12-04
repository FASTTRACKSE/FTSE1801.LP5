package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinBangCap;

@Repository
public class BangCapDaoImpl implements BangCapDao {
	@Autowired
	private SessionFactory sesionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinBangCap> getAll() {
		Session session = sesionFactory.openSession();
		List<ThongTinBangCap> list = session.createQuery("from ThongTinBangCap").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinBangCap> getByPaging(int fistResult, int maxResult) {
		Session session = sesionFactory.openSession();
		List<ThongTinBangCap> list = session.createQuery("from ThongTinBangCap").setFirstResult(fistResult)
				.setMaxResults(maxResult).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinBangCap> findByMaNhanVien(int maNhanVien) {
		Session session = sesionFactory.openSession();
		List<ThongTinBangCap> list = session.createQuery("from ThongTinBangCap where maNhanVien= "+maNhanVien).list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThongTinBangCap bangCap) {
		Session session = sesionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(bangCap);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ThongTinBangCap bangCap) {
		Session session = sesionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(bangCap);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = sesionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(ThongTinBangCap.class, id));
		tx.commit();
		session.close();
	}

}

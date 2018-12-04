package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinGiaDinh;

@Repository
public class ThongTinGiaDinhDaoImpl implements ThongTinGiaDinhDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinGiaDinh> getAll() {
		Session session = sessionFactory.openSession();
		List<ThongTinGiaDinh> list = session.createQuery("from ThongTinGiaDinh").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinGiaDinh> getByPaging(int fistResult, int maxResult) {
		Session session = sessionFactory.openSession();
		List<ThongTinGiaDinh> list = session.createQuery("from ThongTinGiaDinh").setFirstResult(fistResult)
				.setMaxResults(maxResult).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinGiaDinh> findByMaNhanVien(int maNhanVien) {
		Session session = sessionFactory.openSession();
		List<ThongTinGiaDinh> list = session.createQuery("from ThongTinGiaDinh where maNhanVien = "+maNhanVien).list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThongTinGiaDinh thongTinGiaDinh) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(thongTinGiaDinh);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ThongTinGiaDinh thongTinGiaDinh) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(thongTinGiaDinh);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(ThongTinGiaDinh.class, id));
		tx.commit();
		session.close();
	}

}

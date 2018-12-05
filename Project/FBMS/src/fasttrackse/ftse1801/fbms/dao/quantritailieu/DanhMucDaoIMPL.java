package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
@Repository
public class DanhMucDaoIMPL implements DanhMucDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMucTaiLieu> getAllDanhMuc() {
		session = this.sessionFactory.openSession();
		List<DanhMucTaiLieu> listDM = session.createQuery("from DanhMucTaiLieu where isDelete = 0").list();
		session.close();
		return listDM;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMucTaiLieu> getAllDanhMuc(int page, int record) {
		session = this.sessionFactory.openSession();
		List<DanhMucTaiLieu> listDM = session.createQuery("from DanhMucTaiLieu").setFirstResult(page)
				.setMaxResults(record).list();
		session.close();
		return listDM;
	}

	@Override
	public void insertDanhMuc(DanhMucTaiLieu danhMuc) {
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(danhMuc);
		tx.commit();
		session.close();

	}

	@Override
	public void updateDanhMuc(DanhMucTaiLieu danhMuc) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(danhMuc);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteDanhMuc(String maDanhMuc) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(DanhMucTaiLieu.class, maDanhMuc));
		tx.commit();
		session.close();

	}

	@Override
	public DanhMucTaiLieu getDanhMucByMa(String maDanhMuc) {

		session = this.sessionFactory.openSession();
		DanhMucTaiLieu dm = session.get(DanhMucTaiLieu.class, maDanhMuc);
		session.close();
		return dm;
	}

}

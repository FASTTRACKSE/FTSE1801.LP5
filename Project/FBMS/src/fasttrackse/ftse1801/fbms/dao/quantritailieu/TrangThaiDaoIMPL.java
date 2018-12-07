package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;
@Repository
public class TrangThaiDaoIMPL implements TrangThaiDao {
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
	public List<TrangThaiTaiLieu> getAllTrangThaiDel0() {
		session = this.sessionFactory.openSession();
		List<TrangThaiTaiLieu> listTT = session.createQuery("from TrangThaiTaiLieu where isDelete = 0").list();
		session.close();
		return listTT;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiTaiLieu> getAllTrangThaiDel1() {
		session = this.sessionFactory.openSession();
		List<TrangThaiTaiLieu> listTT = session.createQuery("from TrangThaiTaiLieu where isDelete = 1").list();
		session.close();
		return listTT;
	}

	@Override
	public void insertTrangThai(TrangThaiTaiLieu trangThai) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(trangThai);
		tx.commit();
		session.close();

	}

	@Override
	public void updateTrangThai(TrangThaiTaiLieu trangThai) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(trangThai);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteTrangThai(String maTrangThai) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(TrangThaiTaiLieu.class, maTrangThai));
		tx.commit();
		session.close();

	}

	@Override
	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai) {

		session = this.sessionFactory.openSession();
		TrangThaiTaiLieu trangThaiTaiLieu = session.get(TrangThaiTaiLieu.class, maTrangThai);
		session.close();

		return trangThaiTaiLieu;
	}

	@Override
	public List<TaiLieu> getAllbyMaTT(String maTrangThai) {
		// TODO Auto-generated method stub
		return null;
	}

}

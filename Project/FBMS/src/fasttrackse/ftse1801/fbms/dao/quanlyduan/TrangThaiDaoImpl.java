package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.TrangThai;

@Repository
public class TrangThaiDaoImpl implements TrangThaiDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<TrangThai> findAll() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from TrangThai where isDelete = 1", TrangThai.class).list();
	}

	@Override
	public TrangThai findById(String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		TrangThai trangThai = session.get(TrangThai.class, maTrangThai);
		return trangThai;
	}

	@Override
	public void add(TrangThai trangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trangThai);
	}

	@Override
	public void update(TrangThai trangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangThai);
	}

	@Override
	public void delete(TrangThai trangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangThai);
	}

	@Override
	public int checkTenTrangThai(String tenTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThai> listTrangThai = session.createQuery(
				"from TrangThai where tenTrangThai = '" + tenTrangThai + "' and isDelete = 1", TrangThai.class).list();
		return listTrangThai.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThai> listTrangThai(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<TrangThai> listTrangThai = (List<TrangThai>) session.createQuery("from TrangThai where isDelete = 1")
				.setFirstResult(start).setMaxResults(maxRows).list();
		return listTrangThai;
	}

	@Override
	public int countTrangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThai> listTrangThai = session.createQuery("from TrangThai where isDelete = 1", TrangThai.class)
				.list();
		return listTrangThai.size();
	}

}

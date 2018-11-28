package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhTrangHonNhanTT;

@Repository
public class TinhTrangHonNhanDaoTTImpl implements TinhTrangHonNhanDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TinhTrangHonNhanTT> getAllTinhTrangHonNhan() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TinhTrangHonNhanTT");
		List<TinhTrangHonNhanTT> listTinhTrangHonNhan = query.list();

		return listTinhTrangHonNhan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TinhTrangHonNhanTT> findAll() {
		Session session = this.sessionFactory.openSession();
		List<TinhTrangHonNhanTT> list = session.createQuery("from TinhTrangHonNhanTT").list();
		session.close();
		return list;
	}

}

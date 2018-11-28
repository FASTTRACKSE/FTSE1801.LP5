package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhThanhTT;

@Repository
public class TinhThanhDaoTTImpl implements TinhThanhDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TinhThanhTT> listTinhThanh() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from TinhThanhTT");
		@SuppressWarnings("unchecked")
		List<TinhThanhTT> listTinhThanh = query.list();

		return listTinhThanh;
	}
}

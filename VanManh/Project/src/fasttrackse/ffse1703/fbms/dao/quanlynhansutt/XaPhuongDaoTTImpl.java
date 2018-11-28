package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;

@Repository
public class XaPhuongDaoTTImpl implements XaPhuongDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<XaPhuongTT> listXaPhuong(String maQuanHuyen) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from XaPhuongTT where maQuanHuyen = :maQuanHuyen");
		query.setParameter("maQuanHuyen", maQuanHuyen);
		@SuppressWarnings("unchecked")
		List<XaPhuongTT> listXaPhuong = query.list();

		return listXaPhuong;
	}

}

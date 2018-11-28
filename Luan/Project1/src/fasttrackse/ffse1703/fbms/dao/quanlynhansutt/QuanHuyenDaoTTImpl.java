package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;


@Repository
public class QuanHuyenDaoTTImpl implements QuanHuyenDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<QuanHuyenTT> listQuanHuyen(String maThanhPho) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from QuanHuyenTT where maThanhPho = :maThanhPho");
		query.setParameter("maThanhPho", maThanhPho);
		@SuppressWarnings("unchecked")
		List<QuanHuyenTT> listQuanHuyen = query.list();
		return listQuanHuyen;
	}

	
}

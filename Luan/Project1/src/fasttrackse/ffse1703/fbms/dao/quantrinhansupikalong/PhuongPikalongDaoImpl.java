package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.PhuongPikalong;

@Repository
public class PhuongPikalongDaoImpl implements PhuongPikalongDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<PhuongPikalong> listPhuong(String maQuanHuyen) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from PhuongPikalong where maQuanHuyen = :maQuanHuyen");
		query.setParameter("maQuanHuyen", maQuanHuyen);
		@SuppressWarnings("unchecked")
		List<PhuongPikalong> listPhuong = query.list();
		return listPhuong;
	}
	
}

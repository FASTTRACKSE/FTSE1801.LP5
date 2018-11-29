package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.QuanHuyenPikalong;

@Repository
public class QuanHuyenPikalongDaoImpl implements QuanHuyenPikalongDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<QuanHuyenPikalong> listQuanHuyen(String maThanhPho) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from QuanHuyenPikalong where maTinhThanh = :maThanhPho");
		query.setParameter("maThanhPho", maThanhPho);
		@SuppressWarnings("unchecked")
		List<QuanHuyenPikalong> listQuanHuyen = query.list();
		
		return listQuanHuyen;
	}

}

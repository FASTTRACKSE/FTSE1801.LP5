package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.ThanhPhoPikalong;

@Repository
public class ThanhPhoPikalongDaoImpl implements ThanhPhoPikalongDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<ThanhPhoPikalong> listTinhThanh() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from ThanhPhoPikalong");
		@SuppressWarnings("unchecked")
		List<ThanhPhoPikalong> listThanhPho = query.list();
		
		return listThanhPho;
	}

}

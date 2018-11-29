package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.QuocTichPikalong;
@Repository
public class QuocTichPikalongDaoImpl implements QuocTichPikalongDao {

	@Autowired 
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<QuocTichPikalong> listQuocTich() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from QuocTichPikalong");
		@SuppressWarnings("unchecked")
		List<QuocTichPikalong> listQuocTich = query.list();
		return listQuocTich;
	}

}

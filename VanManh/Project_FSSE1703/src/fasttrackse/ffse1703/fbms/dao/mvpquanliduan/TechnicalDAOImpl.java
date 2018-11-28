package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
@Repository
public class TechnicalDAOImpl implements TechnicalDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Technical> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Technical where status = 1", Technical.class).list();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Technical> listTechnical(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Technical> List = (List<Technical>) session.createQuery("FROM Technical where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countTechnical() {
		Session session = sessionFactory.getCurrentSession();
		List<Technical> dm = session.createQuery("from Technical where status = 1", Technical.class).list();
		return  dm.size();
	}

	@Override
	public Technical findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Technical technical = session.get(Technical.class, id);
		return technical;

	}
	@Override
	public int checkNameTechnical(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Technical> dm = session.createQuery("from Technical where nameTechnical = '"+name+"' and status = 1", Technical.class).list();
		
		return  dm.size();
	}
	@Override
	public int checkMaTechnical(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Technical> dm = session.createQuery("from Technical where idTechnical = '"+name+"'", Technical.class).list();
		return  dm.size();
	}


	@Override
	public void addNew(Technical technical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(technical);

	}

	@Override
	public void update(Technical technical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(technical);
	}

	@Override
	public void delete(Technical technical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(technical);

	}

}
package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Domain;

public class DomainDaoImpl implements DomainDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Domain> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Domain where isDelete = 1", Domain.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> listDomain(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Domain> list = (List<Domain>) session.createQuery("FROM Domain where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}
	
	@Override
	public int countDomain() {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where isDelete = 1", Domain.class).list();
		return  dm.size();
	}
	
	@Override
	public int checkNameDomain(String tenDomain) {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where tenDomain = '"+tenDomain+"' and isDelete = 1", Domain.class).list();
		
		return  dm.size();
	}
	@Override
	public int checkMaDomain(String maDomain) {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where maDomain = '"+maDomain+"' ", Domain.class).list();
		return  dm.size();
	}
	@Override
	public Domain findById(String maDomain) {
		Session session = sessionFactory.getCurrentSession();
		Domain dm = session.get(Domain.class, maDomain);
		return dm;

	}

	@Override
	public void addNew(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(domain);

	}

	@Override
	public void update(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domain);
	}

	@Override
	public void delete(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domain);

	}
	

}

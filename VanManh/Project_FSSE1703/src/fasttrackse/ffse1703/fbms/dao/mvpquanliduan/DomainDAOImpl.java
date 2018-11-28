package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;

@Repository
public class DomainDAOImpl implements DomainDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Domain> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Domain where status = 1", Domain.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> listDomain(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Domain> List = (List<Domain>) session.createQuery("FROM Domain where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int countDomain() {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where status = 1", Domain.class).list();
		return  dm.size();
	}
	
	@Override
	public int checkNameDomain(String nameDomain) {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where nameDomain = '"+nameDomain+"' and status = 1", Domain.class).list();
		
		return  dm.size();
	}
	@Override
	public int checkMaDomain(String idDomain) {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> dm = session.createQuery("from Domain where idDomain = '"+idDomain+"' ", Domain.class).list();
		return  dm.size();
	}
	@Override
	public Domain findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Domain dm = session.get(Domain.class, id);
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
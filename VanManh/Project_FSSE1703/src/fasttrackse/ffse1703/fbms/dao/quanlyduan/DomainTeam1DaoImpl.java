package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DomainTeam1;

@Repository
public class DomainTeam1DaoImpl implements DomainTeam1Dao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(DomainTeam1 domainTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(domainTeam1);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DomainTeam1> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<DomainTeam1> list = session.createQuery("FROM DomainTeam1 where is_delete=0").getResultList();

		return list;
	}

	@Override
	public DomainTeam1 findById(String maNghiepVu) {
		Session session = this.sessionFactory.getCurrentSession();
		DomainTeam1 u = (DomainTeam1) session.get(DomainTeam1.class, maNghiepVu);
		return u;
	}

	@Override
	public void delete(DomainTeam1 domainTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainTeam1);
	}

	@Override
	public void update(DomainTeam1 domainTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainTeam1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DomainTeam1> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM DomainTeam1 where is_delete=0").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}


}

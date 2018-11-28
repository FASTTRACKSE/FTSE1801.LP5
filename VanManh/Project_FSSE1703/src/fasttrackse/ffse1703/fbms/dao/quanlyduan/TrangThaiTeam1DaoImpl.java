package fasttrackse.ffse1703.fbms.dao.quanlyduan;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TrangThaiTeam1;

@Repository
public class TrangThaiTeam1DaoImpl implements TrangThaiTeam1Dao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(TrangThaiTeam1 trangthaiTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trangthaiTeam1);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TrangThaiTeam1> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiTeam1> list = session.createQuery("FROM TrangThaiTeam1 where is_delete=0").getResultList();

		return list;
	}

	@Override
	public TrangThaiTeam1 findById(String maTrangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		TrangThaiTeam1 u = (TrangThaiTeam1) session.get(TrangThaiTeam1.class, maTrangThai);
		return u;
	}

	@Override
	public void delete(TrangThaiTeam1 trangthaiTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangthaiTeam1);
	}

	@Override
	public void update(TrangThaiTeam1 trangthaiTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangthaiTeam1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiTeam1> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM TrangThaiTeam1 where is_delete=0").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}

}

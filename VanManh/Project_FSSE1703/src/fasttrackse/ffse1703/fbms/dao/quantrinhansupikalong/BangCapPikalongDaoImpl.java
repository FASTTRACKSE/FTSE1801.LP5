package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;

@Repository
public class BangCapPikalongDaoImpl implements BangCapPikalongDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBangCapPikalong(BangCapPikalong p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateBangCapPikalong(BangCapPikalong p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BangCapPikalong> listBangCapPikalong(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from BangCapPikalong where isActive = :active ").setFirstResult(start).setMaxResults(maxRows);
		query.setParameter("active", 0);
		List<BangCapPikalong> bangCapList = query.list();
		return bangCapList;
	}

	@Override
	public BangCapPikalong getBangCapPikalongById(int id) {
		Session session = this.sessionFactory.openSession();
		BangCapPikalong p = (BangCapPikalong) session.load(BangCapPikalong.class, new Integer(id));
		return p;
	}

	@Override
	public void removeBangCapPikalong(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("update BangCapPikalong set isActive = :active" + " where id = :id");
		query.setParameter("active", 1);
		query.setParameter("id", id);
		@SuppressWarnings("unused")
		int result = query.executeUpdate();
	}

	@Override
	public int total() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from BangCapPikalong").list().size();
	}

	@Override
	public List<BangCapPikalong> viewOne(String maNV) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from BangCapPikalong where MaNv = :MaNv and isActive = :active ");
		query.setParameter("MaNv", maNV);
		query.setParameter("active", 0);
		@SuppressWarnings("unchecked")
		List<BangCapPikalong> viewOne = query.list();
		return viewOne;
	}


}

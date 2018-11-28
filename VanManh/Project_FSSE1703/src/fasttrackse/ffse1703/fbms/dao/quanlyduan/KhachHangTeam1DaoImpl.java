package fasttrackse.ffse1703.fbms.dao.quanlyduan;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.KhachHangTeam1;


@Repository
public class KhachHangTeam1DaoImpl implements KhachHangTeam1Dao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(KhachHangTeam1 khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(khachhang);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<KhachHangTeam1> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHangTeam1> list = session.createQuery("FROM KhachHangTeam1 where is_delete=0 ").getResultList();
		return list;
	}

	@Override
	public KhachHangTeam1 findById(String maKH) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHangTeam1 u = (KhachHangTeam1) session.get(KhachHangTeam1.class, maKH);
		return u;
	}

	@Override
	public void delete(KhachHangTeam1 khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachhang);
	}

	@Override
	public void update(KhachHangTeam1 khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachhang);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHangTeam1> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM KhachHangTeam1 where is_delete=0 ").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	
	


}

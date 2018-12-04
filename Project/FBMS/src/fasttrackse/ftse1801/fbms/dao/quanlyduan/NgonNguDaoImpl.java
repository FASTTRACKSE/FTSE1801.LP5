package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NgonNgu;

public class NgonNguDaoImpl implements NgonNguDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<NgonNgu> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from NgonNgu where isDelete = 1", NgonNgu.class).list();
	}

	@Override
	public NgonNgu getById(String maNgonNgu) {
		Session session = sessionFactory.getCurrentSession();
		NgonNgu ngonNgu =session.get(NgonNgu.class, maNgonNgu);
		return ngonNgu;
	}

	@Override
	public void add(NgonNgu ngonNgu) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(ngonNgu);
		
	}

	@Override
	public void update(NgonNgu ngonNgu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ngonNgu);
	}

	@Override
	public void delete(String maNgonNgu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(maNgonNgu);
		
	}

	@Override
	public int checkNameLanguage(String tenNgonNgu) {
		Session session = sessionFactory.getCurrentSession();
		List<NgonNgu> ngonNgu = session.createQuery("from NgonNgu where tenNgonNgu = '"+tenNgonNgu+"' and isDelete = 1", NgonNgu.class).list();
		
		return  ngonNgu	.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<NgonNgu> listNgonNgu(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NgonNgu> list = (List<NgonNgu>) session.createQuery("FROM NgonNgu where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}

	@Override
	public int countNgonNgu() {
		Session session = sessionFactory.getCurrentSession();
		List<NgonNgu> ngonNgu = session.createQuery("from NgonNgu where isDelete = 1", NgonNgu.class).list();
		return  ngonNgu.size();
	}

	@Override
	public int checkMa(String maNgonNgu) {
		Session session = sessionFactory.getCurrentSession();
		List<NgonNgu> ngonNgu = session.createQuery("from NgonNgu where maNgonNgu = '"+maNgonNgu+"'", NgonNgu.class).list();
		
		return  ngonNgu.size();
	}

}

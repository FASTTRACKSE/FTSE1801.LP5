package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.CongNghe;

public class CongNgheDaoImpl implements CongNgheDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CongNghe> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from CongNghe where isDelete = 1", CongNghe.class).list();
	}

	@Override
	public CongNghe findById(String maCongNghe) {
		Session session = sessionFactory.getCurrentSession();
		CongNghe congNghe = session.get(CongNghe.class, maCongNghe);
		return congNghe;
	}

	@Override
	public void addNew(CongNghe congNghe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(congNghe);

	}

	@Override
	public void update(CongNghe congNghe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(congNghe);
		
	}

	@Override
	public void delete(CongNghe congNghe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(congNghe);
		
	}

	@Override
	public int checkNameCongNghe(String nameCongNghe) {
		Session session = sessionFactory.getCurrentSession();
		List<CongNghe> dm = session.createQuery("from CongNghe where nameCongNghe = '"+nameCongNghe+"' and isDelete = 1", CongNghe.class).list();
		
		return  dm.size();
	}

	@Override
	public int checkMaCongNghe(String maCongNghe) {
		Session session = sessionFactory.getCurrentSession();
		List<CongNghe> dm = session.createQuery("from CongNghe where maCongNghe = '"+maCongNghe+"'", CongNghe.class).list();
		return  dm.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CongNghe> listTechnical(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CongNghe> list = (List<CongNghe>) session.createQuery("FROM CongNghe where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}

	@Override
	public int countTechnical() {
		Session session = sessionFactory.getCurrentSession();
		List<CongNghe> dm = session.createQuery("from CongNghe where isDelete = 1", CongNghe.class).list();
		return  dm.size();
	}

	
}

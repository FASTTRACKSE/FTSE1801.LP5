package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.GiaDinhPikalong;
@Repository
public class GiaDinhPikalongDaoImpl implements GiaDinhPikalongDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addGiaDinhPikalong(GiaDinhPikalong p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateGiaDinhPikalong(GiaDinhPikalong p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public GiaDinhPikalong getGiaDinhPikalongById(int id) {
		Session session = this.sessionFactory.openSession();
		GiaDinhPikalong p = (GiaDinhPikalong) session.load(GiaDinhPikalong.class, new Integer(id));
		return p;
	}

	@Override
	public void removeGiaDinhPikalong(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("update GiaDinhPikalong set isActive = :active" + " where id = :id");
		query.setParameter("active", 1);
		query.setParameter("id", id);
		@SuppressWarnings("unused")
		int result = query.executeUpdate();
		
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GiaDinhPikalong> viewOne(String maNV) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from GiaDinhPikalong where MaNv = :MaNv and isActive = :active ");
		query.setParameter("MaNv", maNV);
		query.setParameter("active", 0);
		@SuppressWarnings("unchecked")
		List<GiaDinhPikalong> viewOne = query.list();
		return viewOne;
	}
	@Override
	public int checkQuanHe(String quanHe,String maNV) {
		Session session = sessionFactory.getCurrentSession();
		List<GiaDinhPikalong> dm = session.createQuery("from GiaDinhPikalong where quanHe = '"+quanHe+"' and maNv = '"+maNV+"'", GiaDinhPikalong.class).list();
		
		return  dm.size();
	}
}

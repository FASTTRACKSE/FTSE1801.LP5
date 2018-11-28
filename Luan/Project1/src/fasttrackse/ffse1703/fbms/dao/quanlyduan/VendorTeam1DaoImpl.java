package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;

@Repository
public class VendorTeam1DaoImpl implements VendorTeam1Dao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<VendorTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VendorTeam1 where isDelete =0",VendorTeam1.class).list();

	}


	@Override
	public void addNew(VendorTeam1 vd) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(vd);
	}

	@Override
	public void update(VendorTeam1 vd) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(vd);
	}

	@Override
	public void delete(String maVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		VendorTeam1 db=session.get(VendorTeam1.class,maVendor);	
		db.setIs_delete(1);
		session.update(db);	
	}


	@Override
	public VendorTeam1 getById(String maVendor) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(VendorTeam1.class,maVendor);	
	}

	@Override
	public void setIsDelete(String maVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		VendorTeam1 db=session.get(VendorTeam1.class,maVendor);	
		db.setIs_delete(0);
		session.update(db);
	}

	@Override
	public int getMa(String maVendor) {
	Session session = this.sessionFactory.getCurrentSession();
	List<VendorTeam1> db = session.createQuery("from VendorTeam1 where tenvd = '"+maVendor+"' AND isDelete =0", VendorTeam1.class).list();	
	return  db.size();
	}

	@Override
	public int getName(String tenVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VendorTeam1> db = session.createQuery("from VendorTeam1 where mavd = '"+tenVendor+"'", VendorTeam1.class).list();	
		return  db.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorTeam1> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VendorTeam1 where isDelete =0").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	

}

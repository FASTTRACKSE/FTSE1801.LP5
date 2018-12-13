package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Vendor;
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Vendor> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Vendor where idDelete = 1", Vendor.class).list();
	}

	@Override
	public Vendor findById(String idVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor Vendor = session.get(Vendor.class, idVendor);
		return Vendor;
	}

	@Override
	public void addNew(Vendor vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vendor);
		
	}

	@Override
	public void update(Vendor vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vendor);
		
	}

	@Override
	public void delete(Vendor vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vendor);
		
	}

	@Override
	public int checkMaVendor(String idVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where idVendor = '"+idVendor+"'", Vendor.class).list();
		return  dm.size();
	}

	@Override
	public int checkTenVendor(String nameVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where nameVendor = '"+nameVendor+"'and isDelete = 1", Vendor.class).list();
		return  dm.size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendor(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Vendor> list = (List<Vendor>) session.createQuery("FROM Vendor where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}

	@Override
	public int countVendor() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where isDelete = 1", Vendor.class).list();
		return  dm.size();
	}

}

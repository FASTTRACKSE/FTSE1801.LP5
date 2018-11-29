package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Vendor> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Vendor where status = 1", Vendor.class).list();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendor(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> List = (List<Vendor>) session.createQuery("FROM Vendor where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countVendor() {
		Session session = sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where status = 1", Vendor.class).list();
		return  dm.size();
	}

	@Override
	@Transactional
	public Vendor findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Vendor Vendor = session.get(Vendor.class, id);
		return Vendor;

	}
	@Override
	@Transactional
	public int checkVendor(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where idVendor = '"+name+"'", Vendor.class).list();
		return  dm.size();
	}

	@Override
	@Transactional
	public void addNew(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Vendor);

	}

	@Override
	@Transactional
	public void update(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Vendor);
	}

	@Override
	@Transactional
	public void delete(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Vendor);

	}

}
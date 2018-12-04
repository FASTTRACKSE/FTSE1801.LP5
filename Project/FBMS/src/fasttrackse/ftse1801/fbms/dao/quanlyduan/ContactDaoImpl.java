package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;

public class ContactDaoImpl implements ContactDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Contact> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Contact where isDelete = 1", Contact.class).list();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listVendor(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Contact> List = (List<Contact>) session.createQuery("FROM Contact where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countContact() {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> dm = session.createQuery("from Contact where isDelete = 1", Contact.class).list();
		return  dm.size();
	}

	@Override
	@Transactional
	public Contact findById(String maContact) {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = session.get(Contact.class, maContact);
		return contact;

	}
	@Override
	@Transactional
	public int checkContact(String tenContact) {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> dm = session.createQuery("from Contact where maContact = '"+tenContact+"'", Contact.class).list();
		return  dm.size();
	}

	@Override
	@Transactional
	public void addNew(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(contact);

	}

	@Override
	@Transactional
	public void update(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(contact);
	}

	@Override
	@Transactional
	public void delete(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(contact);

	}

}

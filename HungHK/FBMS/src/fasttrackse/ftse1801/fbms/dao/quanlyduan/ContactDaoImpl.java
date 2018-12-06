package fasttrackse.ftse1801.fbms.dao.quanlyduan;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;


@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(Contact contact) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(contact);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContact(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Contact> List = (List<Contact>) session.createQuery("FROM Contact where is_delete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int countContact() {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> dm = session.createQuery("from Contact where is_delete = 1", Contact.class).list();
		return  dm.size();
	}
	

	@Override
	public Contact getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Contact.class, id);
	}

	@Override
	public List<Contact> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Contact where is_delete =1", Contact.class).list();
	}

	@Override
	public void update(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(contact);

	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = session.get(Contact.class, id);
		contact.setIs_delete(0);
		session.update(contact);
	}

	@Override
	public int checkMaContact(String maContact) {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> contact = session.createQuery("from Contact where makh = '"+ maContact +"' ", Contact.class).list();
		return contact.size();
	}
	
}

package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;

public class IConTaiLieuDaoIMPL implements IConTaiLieuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<IconTaiLieu> getAllIcon() {
		session = this.sessionFactory.openSession();
		List<IconTaiLieu> listIC = session.createQuery("IconTaiLieu").list();
		session.close();
		return listIC;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IconTaiLieu> getAllIcon(int page, int record) {
		session = this.sessionFactory.openSession();
		List<IconTaiLieu> listIC = session.createQuery("IconTaiLieu").setFirstResult(page).setMaxResults(record).list();
		session.close();
		return listIC;
	}

	@Override
	public void insertIcon(IConTaiLieuDao ic) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ic);
		tx.commit();
		session.close();

	}

	@Override
	public void updateIcon(IConTaiLieuDao ic) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ic);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteIcon(String maIcon) {

		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(IconTaiLieu.class, maIcon));
		tx.commit();
		session.close();

	}

	@Override
	public IconTaiLieu getIconbyMa(String maIcon) {

		session = this.sessionFactory.openSession();
		IconTaiLieu icon = session.get(IconTaiLieu.class, maIcon);
		session.close();

		return icon;
	}

}

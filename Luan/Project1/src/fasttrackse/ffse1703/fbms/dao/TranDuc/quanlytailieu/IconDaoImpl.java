package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;

@Repository
public class IconDaoImpl implements IconDao {
	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	@Override
	public List<IconTaiLieu> listAllIconTaiLieu() {
		Session session = this.sessionFac.openSession();
		List<IconTaiLieu> list = session.createQuery("from IconTaiLieu where isDelete = 0").list();
		session.close();
		return list;
	}

	@Override
	public void addIC(IconTaiLieu ic) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ic);
		tx.commit();
		session.close();
	}

	@Override
	public void updateIC(IconTaiLieu ic) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ic);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteIC(String maIcon) {
		Session session = this.sessionFac.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(session.get(IconTaiLieu.class, maIcon));
		ts.commit();
		session.close();
	}

	@Override
	public IconTaiLieu getICbyID(String maIcon) {
		Session session = this.sessionFac.openSession();
		IconTaiLieu ic = session.get(IconTaiLieu.class, maIcon);
		session.close();
		return ic;
	}
	
}

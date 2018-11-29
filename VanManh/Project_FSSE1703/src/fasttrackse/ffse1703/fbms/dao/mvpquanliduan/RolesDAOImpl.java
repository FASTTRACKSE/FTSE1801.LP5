package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;
@Repository
public class RolesDAOImpl implements RolesDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Roles> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Roles where status = 1", Roles.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> listRoles(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Roles> List = (List<Roles>) session.createQuery("FROM Roles where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<Roles> dm = session.createQuery("from Roles where status = 1", Roles.class).list();
		return  dm.size();
	}
	@Override
	public int checkNameRoles(String nameRoles) {
		Session session = sessionFactory.getCurrentSession();
		List<Roles> dm = session.createQuery("from Roles where nameRoles = '"+nameRoles+"' and status = 1", Roles.class).list();
		
		return  dm.size();
	}

	@Override
	public Roles findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Roles dm = session.get(Roles.class, id);
		return dm;
	}

	@Override
	public void addNew(Roles roles) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Name roles là:" +roles.getNameRoles());
		session.persist(roles);

	}

	@Override
	public void update(Roles roles) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roles);
	}

	@Override
	public void delete(Roles roles) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roles);

	}
}

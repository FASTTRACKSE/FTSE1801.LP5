package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
@Repository
public class DatabaseDAOImpls implements DatabaseDAOs{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Database> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Database where status = 1", Database.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Database> listDatabase(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Database> List = (List<Database>) session.createQuery("FROM Database where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countDatabase() {
		Session session = sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where status = 1", Database.class).list();
		return  dm.size();
	}
	@Override
	public int checkNameDatabase(String nameDatabase) {
		Session session = sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where nameDatabase = '"+nameDatabase+"' and status = 1", Database.class).list();
		
		return  dm.size();
	}
	@Override
	public int checkMaDatabase(String idDatabase) {
		Session session = sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where idDatabase = '"+idDatabase+"' ", Database.class).list();
		return  dm.size();
	}
	@Override
	public Database findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Database dm = session.get(Database.class, id);
		return dm;
	}
	@Override
	public void addNew(Database database) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(database);
	}

	@Override
	public void update(Database database) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(database);
	}

	@Override
	public void delete(Database database) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(database);
	}
}

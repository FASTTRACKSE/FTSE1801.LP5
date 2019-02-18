package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Database;
@Repository
public class DatabaseDaoImpl implements DatabaseDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Database> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Database where isDelete = 1", Database.class).list();
	}

	@Override
	public Database findById(String maDatabase) {
		Session session =this. sessionFactory.getCurrentSession();
		Database dm = session.get(Database.class, maDatabase);
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

	@Override
	public int checkNameDatabase(String tenDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where tenDatabase = '"+ tenDatabase +"' and isDelete = 1", Database.class).list();
		
		return  dm.size();
	}

	@Override
	public int checkMaDatabase(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where maDatabase = '"+ maDatabase +"' ", Database.class).list();
		return  dm.size();
	}

	@Override
	public int countDatabase() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Database> dm = session.createQuery("from Database where isDelete = 1", Database.class).list();
		return  dm.size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Database> listDatabase(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Database> list = (List<Database>) session.createQuery("FROM Database where isDelete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}

}

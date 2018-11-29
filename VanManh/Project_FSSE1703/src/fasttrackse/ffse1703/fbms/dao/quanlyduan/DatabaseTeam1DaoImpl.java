package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DatabaseTeam1;

@Repository
public class DatabaseTeam1DaoImpl implements DatabaseTeam1Dao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DatabaseTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DatabaseTeam1 where isDelete =0",DatabaseTeam1.class).list();

	}

	@Override
	public void delete(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		DatabaseTeam1 db=session.get(DatabaseTeam1.class,maDatabase);	
		db.setIsDelete(1);
		session.update(db);	
	}

	@Override
	public void save(DatabaseTeam1 database) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(database);
		
	}

	@Override
	public DatabaseTeam1 getById(String maDatabase) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(DatabaseTeam1.class,maDatabase);		
	}

	@Override
	public void update(DatabaseTeam1 database) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(database);		
	}

	@Override
	public void setIsDelete(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		DatabaseTeam1 db=session.get(DatabaseTeam1.class,maDatabase);	
		db.setIsDelete(0);
		session.update(db);	
	}
	
	@Override
	public int getName(String tenDatabase) {
	Session session = this.sessionFactory.getCurrentSession();
	List<DatabaseTeam1> db = session.createQuery("from DatabaseTeam1 where ten_Database = '"+tenDatabase+"' AND isDelete =0", DatabaseTeam1.class).list();	
	return  db.size();
	}

}



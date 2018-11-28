package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.FrameworkTeam1;

@Repository
public class FrameworkTeam1DaoImpl implements FrameworkTeam1Dao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<FrameworkTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from FrameworkTeam1 where is_delete =0", FrameworkTeam1.class).list();

	}

	@Override
	public void delete(String ma_framework) {
		Session session = this.sessionFactory.getCurrentSession();
		FrameworkTeam1 frameworkTeam1 = session.get(FrameworkTeam1.class, ma_framework);
		frameworkTeam1.setIs_delete(1);
		session.update(frameworkTeam1);
	}

	@Override
	public void save(FrameworkTeam1 frameworkTeam1) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(frameworkTeam1);

	}

	@Override
	public FrameworkTeam1 getById(String ma_framework) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(FrameworkTeam1.class,ma_framework);		
	}

	@Override
	public void update(FrameworkTeam1 frameworkTeam1) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(frameworkTeam1);		

	}

	@Override
	public void setIsDelete(String ma_framework) {
		Session session = this.sessionFactory.getCurrentSession();
		FrameworkTeam1 famwork=session.get(FrameworkTeam1.class,ma_framework);	
		famwork.setIs_delete(0);
		session.update(famwork);	
	}

	@Override
	public int getName(String ten_framework) {
		Session session = this.sessionFactory.getCurrentSession();
		List<FrameworkTeam1> db = session.createQuery("from FrameworkTeam1 where ten_framework = '"+ten_framework+"' AND is_delete =0", FrameworkTeam1.class).list();	
		return  db.size();
	}

}

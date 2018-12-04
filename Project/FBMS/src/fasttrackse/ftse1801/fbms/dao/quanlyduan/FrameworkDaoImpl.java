package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Framework;

public class FrameworkDaoImpl implements FrameworkDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Framework> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Framework where status = 1", Framework.class).list();
	}

	@Override
	public Framework getById(String maFramework) {
		Session session = sessionFactory.getCurrentSession();
		Framework framework= session.get(Framework.class,maFramework);
		return framework;
	}

	@Override
	public void add(Framework framework) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(framework);		
	}

	@Override
	public void update(Framework framework) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(framework);
		
	}

	@Override
	public void delete(String maFramework) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(maFramework);
		
	}

	@Override
	public int checkNameFramework(String tenFramework) {
		Session session = sessionFactory.getCurrentSession();
		List<Framework> framework = session.createQuery("from Framework where tenFramework = '"+ tenFramework +"' and status = 1", Framework.class).list();
		
		return  framework.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listFramework(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Framework> list = (List<Framework>) session.createQuery("FROM Framework where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return list;
	}
	
	@Override
	public int countFramework() {
		Session session = sessionFactory.getCurrentSession();
		List<Framework> framework = session.createQuery("from Framework where status = 1", Framework.class).list();
		return  framework.size();
	}

}

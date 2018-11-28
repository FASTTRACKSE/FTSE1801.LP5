package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Category> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Category", Category.class).list();

	}


	@Override
	public void addNew (Category category) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(category);
	}

	@Override
	public void update(Category category) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(category);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category db=session.get(Category.class,id);	
		session.delete(db);	
	}


	@Override
	public Category getById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Category.class,id);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Category").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}

}

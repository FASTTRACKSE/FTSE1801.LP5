package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;
@Repository
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<StatusProject> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from StatusProject where status = 1", StatusProject.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StatusProject> listStatusProject(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<StatusProject> List = (List<StatusProject>) session.createQuery("FROM StatusProject where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countStatusProject() {
		Session session = sessionFactory.getCurrentSession();
		List<StatusProject> dm = session.createQuery("from StatusProject where status = 1", StatusProject.class).list();
		return  dm.size();
	}
	@Override
	public int checkNameStatus(String nameStatus) {
		Session session = sessionFactory.getCurrentSession();
		List<StatusProject> dm = session.createQuery("from StatusProject where nameStatus = '"+nameStatus+"' and status = 1", StatusProject.class).list();
		
		return  dm.size();
	}

	@Override
	public StatusProject findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		StatusProject dm = session.get(StatusProject.class, id);
		return dm;
	}

	@Override
	public void addNew(StatusProject Status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Status);

	}

	@Override
	public void update(StatusProject status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(status);
	}

	@Override
	public void delete(StatusProject status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(status);

	}
}

package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;


@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Projects> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Projects where isDelete = 1", Projects.class).list();
	}
	
	@Override
	public List<Projects> listProject(String search,int start,int maxRows) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Projects where isDelete = 1 "+ search).setFirstResult(start)
				.setMaxResults(maxRows).list();
	}
	
	@Override
	public int checkNameProjects(String nameProjects) {
		Session session = sessionFactory.getCurrentSession();
		List<Projects> dm = session.createQuery("from Projects where nameProject = '"+nameProjects+"' and status = 1", Projects.class).list();
		
		return  dm.size();
	}
	@Override
	public int checkMaProjects(String idProjects) {
		Session session = sessionFactory.getCurrentSession();
		List<Projects> dm = session.createQuery("from Projects where idProject = '"+idProjects+"' ", Projects.class).list();
		return  dm.size();
	}
	@Override
	public Projects findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Projects dm = session.get(Projects.class, id);
		return dm;

	}

	@Override
	public void addNew(Projects Projects) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Projects);
	}

	@Override
	public void update(Projects Projects) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Projects);
	}

	@Override
	public void delete(Projects Projects) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Projects);

	}
	@Override
	public List<HoSoNhanVienPikalong> getPm(String maPhongBan){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVienPikalong where isActive = 0 and maPhongBan = '"+maPhongBan+"'", HoSoNhanVienPikalong.class).list();
	}
	@Override
	public UserAccount getAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from UserAccount where username='"+userName+"'", UserAccount.class).getSingleResult();
	
	}
}

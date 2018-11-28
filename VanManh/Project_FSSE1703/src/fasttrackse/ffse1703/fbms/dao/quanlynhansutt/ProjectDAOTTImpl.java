package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ProjectsTT;

@Repository
public class ProjectDAOTTImpl implements ProjectDAOTT {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProjectsTT> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from ProjectsTT where isDelete = 1", ProjectsTT.class).list();
	}

	@Override
	public ProjectsTT findById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProjectsTT dm = session.get(ProjectsTT.class, id);
		return dm;
	}

	@Override
	public void addNew(ProjectsTT projects) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(projects);
	}

	@Override
	public void update(ProjectsTT projects) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(projects);
	}

	@Override
	public void delete(ProjectsTT projects) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(projects);
	}

	@Override
	public int checkNameProjects(String nameProjects) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ProjectsTT> dm = session.createQuery(
				"from ProjectsTT where nameProject = '" + nameProjects + "' and status = 1", ProjectsTT.class).list();

		return dm.size();
	}

	@Override
	public int checkMaProjects(String idProjects) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ProjectsTT> dm = session
				.createQuery("from ProjectsTT where idProject = '" + idProjects + "' ", ProjectsTT.class).list();
		return dm.size();
	}

	@Override
	public List<HoSoNhanVienTT> getPm(String maPhongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVienTT where trang_thai = 1 and ma_phong_ban = '" + maPhongBan + "'",
				HoSoNhanVienTT.class).list();
	}

}

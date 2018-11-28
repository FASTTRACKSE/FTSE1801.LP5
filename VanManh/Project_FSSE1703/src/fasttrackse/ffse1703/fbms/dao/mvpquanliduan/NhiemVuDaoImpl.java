package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;


@Repository
@Transactional
public class NhiemVuDaoImpl implements NhiemVuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void add(Nhiemvu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhiemVu);

	}

	@Override
	public Nhiemvu getByID(String  idProjects) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Nhiemvu.class, idProjects);
	}

	@Override
	public List<Nhiemvu> getByDuAn(String idProjects) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Nhiemvu where status =1 and projects.idProject='"+idProjects+"'", Nhiemvu.class).list();
	}
	@Override
	public List<Nhiemvu> getByMaNhanVien(String idNv) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Nhiemvu where status =1 and hoSoNhanVien.maNv='"+idNv+"'", Nhiemvu.class).list();
	}

	@Override
	public void update(Nhiemvu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhiemVu);

	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Nhiemvu nhiemVu = session.get(Nhiemvu.class, id);
		nhiemVu.setStatus(0);
		session.update(nhiemVu);
	}
	@Override
	public List<Nhiemvu> getByDuAn(String idProjects, String search, int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		// search = "and hoSoNhanVien.maNv = ... and roles.id = ..."
		// from Nhiemvu where status =1 and projects.idProject= "DA0004" and hoSoNhanVien.maNv = "00001"
		
		return session.createQuery("from Nhiemvu where status =1 and projects.idProject='"+idProjects+"' " + search, Nhiemvu.class).setFirstResult(start)
				.setMaxResults(maxRows).list();
	}
	@Override
	public int countNhiemvu(String idProjects, String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Nhiemvu> nv=session.createQuery("from Nhiemvu where status = 1 and projects.idProject='"+idProjects+"' " + search, Nhiemvu.class).list();
		return nv.size();
	}
	@Override
	public Nhiemvu getByid(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Nhiemvu.class, id);
	}
	@Override
	public int checkRole(String maNv,int idRole,String idProject) {
		Session session = sessionFactory.getCurrentSession();
		List<Nhiemvu> nv = session.createQuery("from Nhiemvu where projects.idProject = '"+idProject+"' and roles.idRoles = '"+idRole+"' and hoSoNhanVien.maNv= '"+maNv+"' ", Nhiemvu.class).list();
		
		return  nv.size();
	}


}

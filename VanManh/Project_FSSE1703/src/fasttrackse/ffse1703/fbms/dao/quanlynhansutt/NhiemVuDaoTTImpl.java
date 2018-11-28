package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.NhiemVuTT;

@Repository
@Transactional
public class NhiemVuDaoTTImpl implements NhiemVuDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(NhiemVuTT nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhiemVu);

	}

	@Override
	public NhiemVuTT getByID(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NhiemVuTT.class, id);
	}

	@Override
	public List<NhiemVuTT> getByDuAn(String idProjects) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVuTT where status=1 and projectsTT.idProject='" + idProjects + "'",
				NhiemVuTT.class).list();
	}

	@Override
	public void update(NhiemVuTT nhiemVu) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhiemVu);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		NhiemVuTT nhiemVu = session.get(NhiemVuTT.class, id);
		nhiemVu.setStatus(0);
		session.update(nhiemVu);
	}

	@Override
	public List<NhiemVuTT> getByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVuTT where hoSoNhanVienTT.maNhanVien = " + maNhanVien + "",
				NhiemVuTT.class).list();
	}

}

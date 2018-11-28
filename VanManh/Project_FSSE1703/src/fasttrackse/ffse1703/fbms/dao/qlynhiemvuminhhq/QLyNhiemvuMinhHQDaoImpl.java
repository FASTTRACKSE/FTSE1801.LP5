package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.DuAnMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;



@Repository
public class QLyNhiemvuMinhHQDaoImpl implements QLyNhiemvuMinhHQDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CongViecMinhHQ> findAll(String search) {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> list = session.createQuery("from CongViecMinhHQ where isDelete ='1'"+ search).list();
		return list;
	}

	@Override
	public void addNew(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cv);
	}

	@Override
	public void update(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}

	@Override
	public void delete(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}

	@Override
	public CongViecMinhHQ findByID(int ID) {
		Session session = this.sessionFactory.getCurrentSession();
		CongViecMinhHQ pb = session.get(CongViecMinhHQ.class, ID);
		return pb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CongViecMinhHQ> findAllForPaging(int iDisplayStart, int iDisplayLength, String search) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CongViecMinhHQ> listCongViec = session.createQuery("from CongViecMinhHQ where isDelete = 1 " + search).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return listCongViec;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiMinhHQ> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiMinhHQ> tt = session.createQuery("from TrangThaiMinhHQ").list();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViecMinhHQ> loaiCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiCongViecMinhHQ> cv = session.createQuery("from LoaiCongViecMinhHQ").list();
		return cv;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DuAnMinhHQ> duAn() {
		Session session = sessionFactory.getCurrentSession();
		List<DuAnMinhHQ> da = session.createQuery("from DuAnMinhHQ").list();
		return da;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> nhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> cv = session.createQuery("from HoSoNhanVien").list();
		return cv;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CongViecMinhHQ> searchAll(String search) {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> list = session.createQuery("from CongViecMinhHQ where isDelete = 1"+ search).list();
		return list;
	}
}


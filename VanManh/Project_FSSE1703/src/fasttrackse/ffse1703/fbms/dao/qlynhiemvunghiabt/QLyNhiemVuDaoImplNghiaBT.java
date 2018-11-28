package fasttrackse.ffse1703.fbms.dao.qlynhiemvunghiabt;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.DuAnNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.LoaiCongViecNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.NhiemVu;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.TrangThaiNghiaBT;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;



@Repository
public class QLyNhiemVuDaoImplNghiaBT implements QLyNhiemVuDaoNghiaBT{
	
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<NhiemVu> findAll(String search) {
		Session session = this.sessionFactory.openSession();
		List<NhiemVu> list = session.createQuery("from NhiemVu where isDelete ='0'" + search).list();
		session.close();
		return list;
	}
//thêm
	@Override
	public void addNew(NhiemVu cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cv);
	}
//sửa
	@Override
	public void update(NhiemVu cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}
//xóa
	@Override
	public void delete(NhiemVu cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}

	@Override
	public NhiemVu findByID(int ID) {
		Session session = this.sessionFactory.getCurrentSession();
		NhiemVu pb = session.get(NhiemVu.class, ID);
		return pb;
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<NhiemVu> findAll(int iDisplayStart, int iDisplayLength, String sql) {
//		Session session = this.sessionFactory.openSession();
//		List<NhiemVu> listNhiemVu = session.createQuery(sql).setFirstResult(iDisplayStart)
//				.setMaxResults(iDisplayLength).list();
//		return listNhiemVu;
//	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<NhiemVu> findAllForPaging(int iDisplayStart, int iDisplayLength, String search) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhiemVu> listNhiemVu = session.createQuery("from NhiemVu where isDelete = 0 " + search).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return listNhiemVu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiNghiaBT> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiNghiaBT> tt = session.createQuery("from TrangThaiNghiaBT").list();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViecNghiaBT> loaiCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiCongViecNghiaBT> cv = session.createQuery("from LoaiCongViecNghiaBT").list();
		return cv;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DuAnNghiaBT> duAn() {
		Session session = sessionFactory.getCurrentSession();
		List<DuAnNghiaBT> da = session.createQuery("from DuAnNghiaBT").list();
		return da;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> nhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> cv = session.createQuery("from HoSoNhanVien").list();
		return cv;
	}

	//@SuppressWarnings({ "unchecked", "rawtypes" })
	//@Override
	//public List<NhiemVu> findAllForPaging(int startPosition, int maxResult) {
	//	Session session = this.sessionFactory.getCurrentSession();
	//	Query q = session.createQuery("from NhiemVu where isDelete ='1'");
	//	q.setFirstResult(startPosition);
	//	q.setMaxResults(maxResult);
		
	//	return q.list();		
	//}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NhiemVu> searchAll(String search) {
		Session session = this.sessionFactory.openSession();
		List<NhiemVu> list = session.createQuery("from NhiemVu where isDelete = 0"+ search).list();
		return list;
	}

}


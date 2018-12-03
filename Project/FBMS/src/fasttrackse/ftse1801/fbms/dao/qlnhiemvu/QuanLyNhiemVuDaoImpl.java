package fasttrackse.ftse1801.fbms.dao.qlnhiemvu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThai;

@Repository
public class QuanLyNhiemVuDaoImpl implements QuanLyNhiemVuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public QuanLyNhiemVu findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		QuanLyNhiemVu quanLyNhiemVu = session.get(QuanLyNhiemVu.class, id);
		session.close();
		return quanLyNhiemVu;
	}

	@Override
	public void add(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.persist(qlnv);
		transaction.commit();
		session.close();
	}

	@Override
	public void edit(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(qlnv);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(qlnv);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuanLyNhiemVu> getAll() {
		Session session = sessionFactory.openSession();
		List<QuanLyNhiemVu> list = session.createQuery("from QuanLyNhiemVu where isDelete = 0").getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThai> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThai> list = session.createQuery("from TrangThai").getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViec> loaiCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiCongViec> list = session.createQuery("from LoaiCongViec").getResultList();
		session.close();
		return list;
	}

	// @Override
	// public List<DuAn> duAn() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// @Override
	// public List<VaiTro> vaiTro() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@SuppressWarnings("unchecked")
	@Override
	public List<QuanLyNhiemVu> getAllpage(int page, int size) {
		Session session = sessionFactory.getCurrentSession();
		List<QuanLyNhiemVu> listNhiemVu = session.createQuery("from QuanLyNhiemVu where isDelete = 0").setFirstResult(page).setMaxResults(size)
				.list();
		session.close();
		return listNhiemVu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuanLyNhiemVu> searchAll(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<QuanLyNhiemVu> list = session.createQuery("from QuanLyNhiemVu where isDelete = 0" + search).list();
		session.close();
		return list;
	}

}

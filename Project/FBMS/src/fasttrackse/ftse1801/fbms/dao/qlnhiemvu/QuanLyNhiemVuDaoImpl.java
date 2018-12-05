package fasttrackse.ftse1801.fbms.dao.qlnhiemvu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThaiNhiemVu;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

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
		Session session = sessionFactory.openSession();
		QuanLyNhiemVu quanLyNhiemVu = session.get(QuanLyNhiemVu.class, id);
		session.close();
		return quanLyNhiemVu;
	}

	@Override
	public void add(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(qlnv);
		transaction.commit();
		session.close();
	}

	@Override
	public void edit(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(qlnv);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(QuanLyNhiemVu qlnv) {
		Session session = sessionFactory.openSession();
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
	public List<TrangThaiNhiemVu> trangThai() {
		Session session = sessionFactory.openSession();
		List<TrangThaiNhiemVu> list = session.createQuery("from TrangThaiNhiemVu").getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViec> loaiCongViec() {
		Session session = sessionFactory.openSession();
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
		Session session = sessionFactory.openSession();
		List<QuanLyNhiemVu> listNhiemVu = session.createQuery("from QuanLyNhiemVu where isDelete = 0").setFirstResult(page).setMaxResults(size)
				.list();
		session.close();
		return listNhiemVu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuanLyNhiemVu> searchAll(String search) {
		Session session = sessionFactory.openSession();
		List<QuanLyNhiemVu> list = session.createQuery("from QuanLyNhiemVu where isDelete = 0" + search).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanSu> hoSoNhanVien() {
		Session session = sessionFactory.openSession();
		List<HoSoNhanSu> list = session.createQuery("from HoSoNhanSu").getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> phongBan() {
		Session session = sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").getResultList();
		session.close();
		return list;
	}

}

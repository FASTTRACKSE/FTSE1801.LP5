package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThaiVN;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Repository(value = "quanLyVangNghiDao")
@Transactional(rollbackFor = Exception.class)
public class QuanLyVangNghiDaoIpml implements QuanLyVangNghiDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '2'").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '3'" ).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ThongKeDonXinPhep> danhSachXinNghiNhap() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '1'").getResultList();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ThongKeDonXinPhep> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ThongKeDonXinPhep where trangThai = '1'");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	public long totalRecords() {
		Session session = this.sessionFactory.getCurrentSession();
		String queryString = "SELECT count(*) FROM ThongKeDonXinPhep WHERE trang_thai = 'Nháp'";
		Query<?> query = session.createQuery(queryString);
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '4'")
				.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<LyDoXinNghi> loadAllLyDo() {
		Session session = sessionFactory.getCurrentSession();
		List<LyDoXinNghi> list = session.createQuery("from LyDoXinNghi").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<HoSoNhanVien> loadAllHoSo() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
		return list;

	}
	
	@SuppressWarnings("unchecked")
	public List<PhongBan> loadAllPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		return list;

	}

	public int KiemTraNgayNghi(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = sessionFactory.getCurrentSession();
		String rowCount = session.createSQLQuery("select count(*) from `ngay_nghi` where `ma_nhan_vien` = '"
				+ thongKeDonXinPhep.getNgayNghi().getMaNhanVien() + "'").getSingleResult().toString();
		return Integer.parseInt(rowCount);
	}

	public void create(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(thongKeDonXinPhep) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`,`ten_nhan_vien`) VALUES ('"
							+ thongKeDonXinPhep.getNgayNghi().getMaNhanVien() + "', '0', '12', '"+ thongKeDonXinPhep.getTenNhanVien() +"')")
					.executeUpdate();
		} 
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '1'  where id =" + thongKeDonXinPhep.getId())
				.executeUpdate();
	}

	public void createWait(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(thongKeDonXinPhep) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`,`ten_nhan_vien`) VALUES ('"
							+ thongKeDonXinPhep.getNgayNghi().getMaNhanVien() + "', '0', '12', '"+ thongKeDonXinPhep.getTenNhanVien() +"')")
					.executeUpdate();
		}
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '2'  where id =" + thongKeDonXinPhep.getId())
				.executeUpdate();

	}

	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '3'  where id =" + thongKeDonXinPhep.getId())
				.executeUpdate();
		int soNgayNghi = thongKeDonXinPhep.getSoNgayNghi();
		int soNgayDaNghi = thongKeDonXinPhep.getNgayNghi().getSoNgayDaNghi();
		int soNgayConLai = thongKeDonXinPhep.getNgayNghi().getSoNgayConLai();
		int maNhanVien = thongKeDonXinPhep.getNgayNghi().getMaNhanVien();
		if (soNgayConLai == 0) {
			session.createQuery("update NgayNghi set soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
					+ "where maNhanVien = " + maNhanVien).executeUpdate();
		} else if (soNgayNghi > soNgayConLai) {
			session.createQuery("update NgayNghi set soNgayConLai = 0,soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
					+ "where maNhanVien = " + maNhanVien).executeUpdate();
		} else {
			session.createQuery("update NgayNghi set soNgayConLai = " + (soNgayConLai - soNgayNghi) + ",soNgayDaNghi = "
					+ (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien).executeUpdate();
		}

	}

	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(thongKeDonXinPhep) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`) VALUES ('"
							+ thongKeDonXinPhep.getNgayNghi().getMaNhanVien() + "', '0', '12', '"+ thongKeDonXinPhep.getTenNhanVien() +"')")
					.executeUpdate();
		}
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '4'  where id =" + thongKeDonXinPhep.getId())
				.executeUpdate();

	}

	public ThongKeDonXinPhep findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongKeDonXinPhep list = (ThongKeDonXinPhep) session.get(ThongKeDonXinPhep.class, id);
		return list;
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		;
		session.update(thongKeDonXinPhep);

	}

	@SuppressWarnings("unchecked")
	public List<NgayNghi> danhSachNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<NgayNghi> list = session.createQuery("from NgayNghi").getResultList();
		return list;
	}

	public NgayNghi findByIdDateOff(int maNhanVien) {
		Session session = this.sessionFactory.getCurrentSession();
		NgayNghi list = (NgayNghi) session.get(NgayNghi.class, maNhanVien);
		return list;
	}

	public void deleteDateOff(int maNhanVien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findByIdDateOff(maNhanVien));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ThongKeDonXinPhep> findAllForPagingCD(int startPosition, int maxResult, String search) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ThongKeDonXinPhep where trangThai = '2'" + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ThongKeDonXinPhep> findAllForPagingD(int startPosition, int maxResult, String search) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ThongKeDonXinPhep where trangThai = '3'" + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ThongKeDonXinPhep> findAllForPagingTC(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ThongKeDonXinPhep where trangThai = '4'");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<NgayNghi> findAllForPagingNN(int startPosition, int maxResult,String search) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from NgayNghi " + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from TrangThaiVN ");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrangThaiVN> danhSachTrangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiVN> list = session.createQuery("from TrangThaiVN").getResultList();
		return list;
	}

	public TrangThaiVN findByIdTrangThai(int id) {
		Session sesion = sessionFactory.getCurrentSession();
		TrangThaiVN list = (TrangThaiVN) sesion.get(TrangThaiVN.class, id);
		return list;
	}

	public void createTrangThai(TrangThaiVN trangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(trangThai);
	}

	public void deleteTrangThai(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(findByIdTrangThai(id));
	}

	public void updateTrangThai(TrangThaiVN trangThai) {
		Session session = sessionFactory.getCurrentSession();
		session.update(trangThai);
	}

	public void createNgayNghi(NgayNghi ngayNghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(ngayNghi);
	}
	
	public void updateNgayNghi(NgayNghi ngayNghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ngayNghi);
	}
	
	@SuppressWarnings("unchecked")
	public List<ThongKeDonXinPhep> listbyPhongBan(String maPB) {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session
				.createQuery("from ThongKeDonXinPhep  where trangThai = '2' and maPhongBan ='" + maPB + "'  ")
				.getResultList();
		return list;
	}

}

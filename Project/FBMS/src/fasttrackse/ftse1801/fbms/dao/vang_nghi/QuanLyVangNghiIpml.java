package fasttrackse.ftse1801.fbms.dao.vang_nghi;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.DonXinNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.LoaiNghiPhep;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TinhTrangNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TrangThaiVN;


@Repository(value = "quanLyVangNghiDao")
public class QuanLyVangNghiIpml implements QuanLyVangNghiDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DonXinNghi> danhSachNghiChoDuyet() {
		Session session = sessionFactory.openSession();
		List<DonXinNghi> list = session.createQuery("from DonXinNghi where maTrangThai = '2'").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonXinNghi> danhSachXinNghiDuyet() {
		Session session = sessionFactory.openSession();
		List<DonXinNghi> list = session.createQuery("from DonXinNghi where maTrangThai = '3'").getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DonXinNghi> danhSachXinNghiNhap() {
		Session session = sessionFactory.openSession();
		List<DonXinNghi> list = session.createQuery("from DonXinNghi where maTrangThai = '1'").getResultList();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DonXinNghi> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from DonXinNghi where maTrangThai = '1'");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DonXinNghi> danhSachXinNghiTuChoi() {
		Session session = sessionFactory.openSession();
		List<DonXinNghi> list = session.createQuery("from DonXinNghi where maTrangThai = '4'")
				.getResultList();
		return list;
	}

	@Override
	public void create(DonXinNghi donXinNghi) {
		Session session = this.sessionFactory.openSession();
		if (KiemTraNgayNghi(donXinNghi) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`,`ten_nhan_vien`) VALUES ('"
							+ donXinNghi.getIdLoaiNghi().getMaLoaiNghi() + "', '0', '12', '"+ donXinNghi.getMaNhanVien() +"')")
					.executeUpdate();
		} 
		session.save(donXinNghi);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '1'  where id =" + donXinNghi.getIdDonXinPhep())
				.executeUpdate();
	}

	@Override
	public void createWait(DonXinNghi donXinNghi) {
		Session session = this.sessionFactory.openSession();
		if (KiemTraNgayNghi(donXinNghi) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`,`ten_nhan_vien`) VALUES ('"
							+ donXinNghi.getIdLoaiNghi().getMaLoaiNghi() + "', '0', '12', '"+ donXinNghi.getMaNhanVien() +"')")
					.executeUpdate();
		}
		session.save(donXinNghi);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '2'  where id =" + donXinNghi.getIdDonXinPhep())
				.executeUpdate();
	}

	@Override
	public void createBrowse(DonXinNghi donXinNghi) {
		Session session = this.sessionFactory.openSession();
		session.save(donXinNghi);
		session.createQuery("update DonXinNghi set maTangThai = '3'  where id =" + donXinNghi.getIdDonXinPhep())
				.executeUpdate();
		int soNgayNghi = donXinNghi.getSoNgayNghi();
		int soNgayDaNghi = donXinNghi.getMaNhanVien().getNgayDaNghi();
		int soNgayConLai = donXinNghi.getMaNhanVien().getSoNgayConLai();
		HoSoNhanSu maNhanVien = donXinNghi.getMaNhanVien().getIdNhanVien();
		if (soNgayConLai == 0) {
			session.createQuery("update TinhTrangNghi set soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
					+ "where maNhanVien = " + maNhanVien).executeUpdate();
		} else if (soNgayNghi > soNgayConLai) {
			session.createQuery("update TinhTrangNghi set soNgayConLai = 0,soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
					+ "where maNhanVien = " + maNhanVien).executeUpdate();
		} else {
			session.createQuery("update TinhTrangNghi set soNgayConLai = " + (soNgayConLai - soNgayNghi) + ",soNgayDaNghi = "
					+ (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien).executeUpdate();
		}
	}

	@Override
	public void createfeedback(DonXinNghi donXinNghi) {
		Session session = this.sessionFactory.openSession();
		if (KiemTraNgayNghi(donXinNghi) == 0) {
			session.createSQLQuery(
					"INSERT INTO `ngay_nghi`(`ma_nhan_vien`,`so_ngay_da_nghi`,`so_ngay_con_lai`) VALUES ('"
							+ donXinNghi.getMaNhanVien().getIdNhanVien() + "', '0', '12', '"+ donXinNghi.getMaNhanVien() +"')")
					.executeUpdate();
		}
		session.save(donXinNghi);
		session.createQuery("update DonXinNghi set trangThai = '4'  where id =" + donXinNghi.getIdDonXinPhep())
				.executeUpdate();
	}

	@Override
	public int KiemTraNgayNghi(DonXinNghi maNhanVien) {
		Session session = sessionFactory.openSession();
		String rowCount = session.createSQLQuery("select count(*) from `ngay_nghi` where `ma_nhan_vien` = '"
				+ maNhanVien.getIdLoaiNghi().getMaLoaiNghi() + "'").getSingleResult().toString();
		return Integer.parseInt(rowCount);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiNghiPhep> loadAllLyDo() {
		Session session = sessionFactory.openSession();
		List<LoaiNghiPhep> list = session.createQuery("from LoaiNghiPhep").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanSu> loadAllHoSo() {
		Session session = sessionFactory.openSession();
		List<HoSoNhanSu> list = session.createQuery("from HoSoNhanSu").list();
		return list;
	}

	@Override
	public DonXinNghi findById(int idDonXinPhep) {
		Session session = this.sessionFactory.openSession();
		DonXinNghi list = (DonXinNghi) session.get(DonXinNghi.class, idDonXinPhep);
		return list;
	}

	@Override
	public void delete(int idDonXinPhep) {
		Session session = this.sessionFactory.openSession();
		session.delete(findById(idDonXinPhep));
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DonXinNghi> findAllForPagingCD(int startPosition, int maxResult, String search) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from DonXinNghi where maTrangThai = '2'" + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DonXinNghi> findAllForPagingD(int startPosition, int maxResult, String search) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from DonXinNghi where maTrangThai = '3'" + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DonXinNghi> findAllForPagingTC(int startPosition, int maxResult) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from DonXinNghi where maTrangThai = '4'");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TinhTrangNghi> findAllForPagingNN(int startPosition, int maxResult, String search) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from TinhTrangNghi " + search);
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> loadAllPhongBan() {
		Session session = sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		return list;
	}

	@Override
	public long totalRecords() {
		Session session = this.sessionFactory.openSession();
		String queryString = "SELECT count(*) FROM DonXinNghi WHERE trang_thai = 'Nháp'";
		Query<?> query = session.createQuery(queryString);
		return (Long) query.uniqueResult();
	}

	@Override
	public void updateNhap(DonXinNghi donXinNghi) {
		Session session = this.sessionFactory.openSession();
		;
		session.update(donXinNghi);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TinhTrangNghi> danhSachNgayNghi() {
		Session session = sessionFactory.openSession();
		List<TinhTrangNghi> list = session.createQuery("from TinhTrangNghi").getResultList();
		return list;
	}

	@Override
	public TinhTrangNghi findByIdDateOff(int maNhanVien) {
		Session session = this.sessionFactory.openSession();
		TinhTrangNghi list = (TinhTrangNghi) session.get(TinhTrangNghi.class, maNhanVien);
		return list;
	}

	@Override
	public void deleteDateOff(int maNhanVien) {
		Session session = this.sessionFactory.openSession();
		session.delete(findByIdDateOff(maNhanVien));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiVN> danhSachTrangThai() {
		Session session = sessionFactory.openSession();
		List<TrangThaiVN> list = session.createQuery("from TrangThaiVN").getResultList();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from TrangThaiVN ");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);

		return q.list();
	}

	@Override
	public TrangThaiVN findByIdTrangThai(int idTinhTrang) {
		Session sesion = sessionFactory.openSession();
		TrangThaiVN list = (TrangThaiVN) sesion.get(TrangThaiVN.class, idTinhTrang);
		return list;
	}

	@Override
	public void createTrangThai(TrangThaiVN trangThai) {
		Session session = sessionFactory.openSession();
		session.update(trangThai);
	}

	@Override
	public void deleteTrangThai(int idTinhTrang) {
		Session session = sessionFactory.openSession();
		session.delete(findByIdTrangThai(idTinhTrang));
	}

	@Override
	public void updateTrangThai(TrangThaiVN trangThai) {
		Session session = sessionFactory.openSession();
		session.update(trangThai);
	}

	@Override
	public void createNgayNghi(TinhTrangNghi ngayNghi) {
		Session session = this.sessionFactory.openSession();
		session.save(ngayNghi);
	}

	@Override
	public void updateNgayNghi(TinhTrangNghi ngayNghi) {
		Session session = this.sessionFactory.openSession();
		session.update(ngayNghi);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonXinNghi> listbyPhongBan(String maPhongBan) {
		Session session = sessionFactory.openSession();
		List<DonXinNghi> list = session
				.createQuery("from DonXinNghi  where maTrangThai = '2' and maPhongBan ='" + maPhongBan + "'  ")
				.getResultList();
		return list;
	}

	
}

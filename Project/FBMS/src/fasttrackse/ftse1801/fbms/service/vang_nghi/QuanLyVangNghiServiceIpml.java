package fasttrackse.ftse1801.fbms.service.vang_nghi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.vang_nghi.QuanLyVangNghiDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.DonXinNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.LoaiNghiPhep;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TinhTrangNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TrangThaiVN;

@Service
public class QuanLyVangNghiServiceIpml implements QuanLyVangNghiService{
	@Autowired
	private QuanLyVangNghiDao quanLyVangNghiDao;
	
	public void setQuanLyVangNghiDao(QuanLyVangNghiDao quanLyVangNghiDao) {
		this.quanLyVangNghiDao = quanLyVangNghiDao;
	}
	
	@Override
	public List<DonXinNghi> danhSachXinNghiChoDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiDuyet();
	}

	@Override
	public List<DonXinNghi> danhSachXinNghiDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiDuyet();
	}

	@Override
	public List<DonXinNghi> danhSachXinNghiNhap() {
		return this.quanLyVangNghiDao.danhSachXinNghiNhap();
	}

	@Override
	public List<DonXinNghi> findAllForPaging(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPaging(startPosition, maxResult);
	}

	@Override
	public List<DonXinNghi> findAllForPagingCD(int startPosition, int maxResult, String search) {
		return this.quanLyVangNghiDao.findAllForPagingCD(startPosition, maxResult, search);
	}

	@Override
	public List<DonXinNghi> findAllForPagingD(int startPosition, int maxResult, String search) {
		return this.quanLyVangNghiDao.findAllForPagingD(startPosition, maxResult, search);
	}

	@Override
	public List<DonXinNghi> findAllForPagingTC(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPagingTC(startPosition, maxResult);
	}

	@Override
	public List<TinhTrangNghi> findAllForPagingNN(int startPosition, int maxResult, String search) {
		return this.quanLyVangNghiDao.findAllForPagingNN(startPosition, maxResult, search);
	}

	@Override
	public long totalRecords() {
		return this.quanLyVangNghiDao.totalRecords();
	}

	@Override
	public List<DonXinNghi> danhSachXinNghiTuChoi() {
		return this.quanLyVangNghiDao.danhSachXinNghiTuChoi();
	}

	@Override
	public void create(DonXinNghi thongKeDonXinPhep) {
		quanLyVangNghiDao.create(thongKeDonXinPhep);
		
	}

	@Override
	public void createWait(DonXinNghi thongKeDonXinPhep) {
		quanLyVangNghiDao.createWait(thongKeDonXinPhep);
		
	}

	@Override
	public void createBrowse(DonXinNghi thongKeDonXinPhep) {
		quanLyVangNghiDao.createBrowse(thongKeDonXinPhep);
		
	}

	@Override
	public void createfeedback(DonXinNghi thongKeDonXinPhep) {
		quanLyVangNghiDao.createfeedback(thongKeDonXinPhep);
		
	}

	@Override
	public List<LoaiNghiPhep> loadAllLyDo() {
		return this.quanLyVangNghiDao.loadAllLyDo();
	}

	@Override
	public List<HoSoNhanSu> loadAllHoSo() {
		return this.quanLyVangNghiDao.loadAllHoSo();
	}

	@Override
	public List<PhongBan> loadAllPhongBan() {
		return this.quanLyVangNghiDao.loadAllPhongBan();
	}

	@Override
	public DonXinNghi findById(int id) {
		return this.quanLyVangNghiDao.findById(id);
	}

	@Override
	public void delete(int id) {
		quanLyVangNghiDao.delete(id);
	}

	@Override
	public void updateNhap(DonXinNghi donXinNghi) {
		quanLyVangNghiDao.updateNhap(donXinNghi);
	}

	@Override
	public List<TinhTrangNghi> danhSachNgayNghi() {
		return this.quanLyVangNghiDao.danhSachNgayNghi();
	}

	@Override
	public TinhTrangNghi findByIdDateOff(int maNhanVien) {
		return this.quanLyVangNghiDao.findByIdDateOff(maNhanVien);
	}

	@Override
	public void deleteDateOff(int maNhanVien) {
		quanLyVangNghiDao.deleteDateOff(maNhanVien);
	}

	@Override
	public List<TrangThaiVN> danhSachTrangThai() {
		return this.quanLyVangNghiDao.danhSachTrangThai();
	}

	@Override
	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPagingTrangThai(startPosition, maxResult);
	}

	@Override
	public TrangThaiVN findByIdTrangThai(int id) {
		return this.quanLyVangNghiDao.findByIdTrangThai(id);
	}

	@Override
	public void createTrangThai(TrangThaiVN trangThai) {
		quanLyVangNghiDao.createTrangThai(trangThai);
	}

	@Override
	public void deleteTrangThai(int id) {
		quanLyVangNghiDao.deleteTrangThai(id);
	}

	@Override
	public void updateTrangThai(TrangThaiVN maTrangThai) {
		quanLyVangNghiDao.updateTrangThai(maTrangThai);
	}

	@Override
	public void createNgayNghi(TinhTrangNghi ngayNghi) {
		quanLyVangNghiDao.createNgayNghi(ngayNghi);
	}

	@Override
	public void updateNgayNghi(TinhTrangNghi ngayNghi) {
		quanLyVangNghiDao.updateNgayNghi(ngayNghi);
	}

	@Override
	public List<DonXinNghi> listbyPhongBan(String maPhongBan) {
		return quanLyVangNghiDao.listbyPhongBan(maPhongBan);
	}

}

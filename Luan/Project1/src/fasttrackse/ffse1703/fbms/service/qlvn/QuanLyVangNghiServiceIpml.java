package fasttrackse.ffse1703.fbms.service.qlvn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.dao.qlvn.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThaiVN;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
@Service
@Transactional
public class QuanLyVangNghiServiceIpml implements QuanLyVangNghiService {
	@Autowired
	private QuanLyVangNghiDao quanLyVangNghiDao;
	
	public void setQuanLyVangNghiDao(QuanLyVangNghiDao quanLyVangNghiDao) {
		this.quanLyVangNghiDao = quanLyVangNghiDao;
	}
	
	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiChoDuyet();
	}

	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiDuyet();
	}
	
	public  void create(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.create(thongKeDonXinPhep);
		
	}
	
	public List<LyDoXinNghi> loadAllLyDo() {
		return this.quanLyVangNghiDao.loadAllLyDo();
	}

	public List<TrangThaiVN> danhSachTrangThai(){
		return this.quanLyVangNghiDao.danhSachTrangThai();
	}


	public List<HoSoNhanVien> loadAllHoSo() {
		return this.quanLyVangNghiDao.loadAllHoSo();
	}

	public List<PhongBan> loadAllPhongBan() {
		return this.quanLyVangNghiDao.loadAllPhongBan();
	}
	
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi() {
		return this.quanLyVangNghiDao.danhSachXinNghiTuChoi();
	}
	
	public void createWait(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createWait(thongKeDonXinPhep);
		
	}

	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createBrowse(thongKeDonXinPhep);
		
	}

	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createfeedback(thongKeDonXinPhep);
		
	}

	public ThongKeDonXinPhep findById(int id) {
		return this.quanLyVangNghiDao.findById(id);
	}

	public void delete(int id) {
		quanLyVangNghiDao.delete(id);
		
	}

	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.updateNhap(thongKeDonXinPhep);
		
	}
	public long totalRecords() {
		
		return this.quanLyVangNghiDao.totalRecords();
	}

	public List<ThongKeDonXinPhep> danhSachXinNghiNhap() {
		return this.quanLyVangNghiDao.danhSachXinNghiNhap();
	}

	public List<NgayNghi> danhSachNgayNghi() {
		return this.quanLyVangNghiDao.danhSachNgayNghi();
	}

	public NgayNghi findByIdDateOff(int maNhanVien) {
		return this.quanLyVangNghiDao.findByIdDateOff(maNhanVien);
	}

	public void deleteDateOff(int maNhanVien) {
		quanLyVangNghiDao.deleteDateOff(maNhanVien);
		
	}

	public List<ThongKeDonXinPhep> findAllForPaging(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPaging(startPosition, maxResult);
	}

	public List<ThongKeDonXinPhep> findAllForPagingCD(int startPosition, int maxResult ,String search) {
		return this.quanLyVangNghiDao.findAllForPagingCD(startPosition, maxResult, search);
	}

	public List<ThongKeDonXinPhep> findAllForPagingD(int startPosition, int maxResult, String search) {
		return this.quanLyVangNghiDao.findAllForPagingD(startPosition, maxResult, search);
	}

	public List<ThongKeDonXinPhep> findAllForPagingTC(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPagingTC(startPosition, maxResult);
	}

	public List<NgayNghi> findAllForPagingNN(int startPosition, int maxResult, String search) {
		return this.quanLyVangNghiDao.findAllForPagingNN(startPosition, maxResult, search);
	}

	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult) {
		return this.quanLyVangNghiDao.findAllForPagingTrangThai(startPosition, maxResult);
	}

	public TrangThaiVN findByIdTrangThai(int id) {
		return this.quanLyVangNghiDao.findByIdTrangThai(id);
	}

	public void createTrangThai(TrangThaiVN trangThai) {
		quanLyVangNghiDao.createTrangThai(trangThai);
	}

	public void deleteTrangThai(int id) {
		quanLyVangNghiDao.deleteTrangThai(id);
	}

	public void updateTrangThai(TrangThaiVN trangThai) {
		quanLyVangNghiDao.updateTrangThai(trangThai);
	}

	public void createNgayNghi(NgayNghi ngayNghi) {
		quanLyVangNghiDao.createNgayNghi(ngayNghi);
	}

	public void updateNgayNghi(NgayNghi ngayNghi) {
		quanLyVangNghiDao.updateNgayNghi(ngayNghi);
		
	}
	public List<ThongKeDonXinPhep> listbyPhongBan(String maPB){
		return quanLyVangNghiDao.listbyPhongBan(maPB);
	}
	
	
}

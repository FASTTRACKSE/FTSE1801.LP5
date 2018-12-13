package fasttrackse.ftse1801.fbms.service.vang_nghi;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.DonXinNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.LoaiNghiPhep;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TinhTrangNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TrangThaiVN;

public interface QuanLyVangNghiService {
	public List<DonXinNghi> danhSachXinNghiChoDuyet();

	public List<DonXinNghi> danhSachXinNghiDuyet();

	public List<DonXinNghi> danhSachXinNghiNhap();
	
	public List<DonXinNghi> findAllForPaging(int startPosition, int maxResult);
	
    public List<DonXinNghi> findAllForPagingCD(int startPosition, int maxResult,String search);
	
	public List<DonXinNghi> findAllForPagingD(int startPosition, int maxResult, String search);
	
	public List<DonXinNghi> findAllForPagingTC(int startPosition, int maxResult);
	
	public List<TinhTrangNghi> findAllForPagingNN(int startPosition, int maxResult, String search);
	
	public long totalRecords();
	
	public List<DonXinNghi> danhSachXinNghiTuChoi();
	
	public void create(DonXinNghi donXinNghi);
	
	public void createWait(DonXinNghi donXinNghi);
	
	public void createBrowse(DonXinNghi donXinNghi);
	
	public void createfeedback(DonXinNghi donXinNghi);
	
	public List<LoaiNghiPhep> loadAllLyDo();
	
	public List<HoSoNhanSu> loadAllHoSo();
	
	public List<PhongBan> loadAllPhongBan();
	
	public DonXinNghi findById(int id);
	
	public void delete(int id);
	
	public void updateNhap(DonXinNghi donXinNghi) ;
	
    public List<TinhTrangNghi> danhSachNgayNghi();
	
	public TinhTrangNghi findByIdDateOff(int maNhanVien);
	
	public void deleteDateOff(int maNhanVien); 
	
	public List<TrangThaiVN> danhSachTrangThai();
	
	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult);
	
	public TrangThaiVN findByIdTrangThai(int id);
	
	public void createTrangThai(TrangThaiVN trangThai);
	
	public void deleteTrangThai(int id);
	
	public void updateTrangThai(TrangThaiVN maTrangThai);
	
	public void createNgayNghi(TinhTrangNghi ngayNghi);
		
    public void updateNgayNghi(TinhTrangNghi ngayNghi);

    public List<DonXinNghi> listbyPhongBan(String maPhongBan);
}

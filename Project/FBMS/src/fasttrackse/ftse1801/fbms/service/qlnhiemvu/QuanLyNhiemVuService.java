package fasttrackse.ftse1801.fbms.service.qlnhiemvu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThaiNhiemVu;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

public interface QuanLyNhiemVuService {
public QuanLyNhiemVu findById(int id);
	
	public void add(QuanLyNhiemVu qlnv);
	
	public void edit(QuanLyNhiemVu qlnv);
	
	public void delete(QuanLyNhiemVu qlnv);
	
	public List<QuanLyNhiemVu> getAll();
	
	public List<TrangThaiNhiemVu> trangThai();
	
	public List<LoaiCongViec> loaiCongViec();
	
	public List<HoSoNhanSu> hoSoNhanVien();
	
	public List<PhongBan> phongBan();
	
//	public List<DuAn> duAn();
//	
//	public List<VaiTro> vaiTro();
	
	public List<QuanLyNhiemVu> getAllpage(int page, int size);
	
	public List<QuanLyNhiemVu> searchAll(String search);
}

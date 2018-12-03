package fasttrackse.ftse1801.fbms.service.qlnhiemvu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThai;

public interface QuanLyNhiemVuService {
public QuanLyNhiemVu findById(int id);
	
	public void add(QuanLyNhiemVu qlnv);
	
	public void edit(QuanLyNhiemVu qlnv);
	
	public void delete(QuanLyNhiemVu qlnv);
	
	public List<QuanLyNhiemVu> getAll();
	
	public List<TrangThai> trangThai();
	
	public List<LoaiCongViec> loaiCongViec();
	
//	public List<DuAn> duAn();
//	
//	public List<VaiTro> vaiTro();
	
	public List<QuanLyNhiemVu> getAllpage(int page, int size);
	
	public List<QuanLyNhiemVu> searchAll(String search);
}

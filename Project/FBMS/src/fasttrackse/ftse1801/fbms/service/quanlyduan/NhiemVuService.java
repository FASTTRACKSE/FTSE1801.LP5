package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;

public interface NhiemVuService {
	
	public NhiemVu getByMaDuAn(int maDuAn);
	
	public NhiemVu getByMaNhiemVu(int maNhiemVu);
	
	public List<NhiemVu> getByMaNhanVien(int maNhanVien);

	public List<NhiemVu> getByDuAn(int maDuAn);
	
	public List<NhiemVu> getByDuAn(int maDuAn, String search, int start, int maxRows);
	
	public void add(NhiemVu nhiemVu);

	public void update(NhiemVu nhiemVu);

	public void delete(int maNhiemVu);
	 
	public int countNhiemvu(int maDuAn, String search);
	
	public int checkVaiTro(int maNhanVien, String maVaiTro, int maDuAn);
}

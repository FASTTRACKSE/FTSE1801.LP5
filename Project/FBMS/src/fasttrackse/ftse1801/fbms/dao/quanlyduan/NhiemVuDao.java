package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;

public interface NhiemVuDao {
	public void add(NhiemVu nhiemVu);

	public NhiemVu getByID(String maDuAn);
	public NhiemVu getByid(int maNhiemVu);

	public List<NhiemVu> getByDuAn(String maDuAn);
	
	public List<NhiemVu> getByDuAn(String maDuAn, String search,int start,int maxRows);

	public void update(NhiemVu nhiemVu);

	public void delete(int maNhiemVu);
	
	public List<NhiemVu> getByMaNhanVien(int maNhanVien);
	 
	public int countNhiemvu(String maDuAn, String search);
	
	public int checkVaiTro(int maNhanVien,String maVaiTro,String maDuAn);
}

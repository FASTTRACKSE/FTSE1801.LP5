package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;


public interface QuanLyHoSoServiceTT {
	public List<HoSoNhanVienTT> getAllHoSo();

	public List<HoSoNhanVienTT> getAllHoSo(int iDisplayStart, int iDisplayLength, String sql);

	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien);

	public String getSQL(HttpServletRequest request, String maPhongBan);

	public List<HoSoNhanVienTT> getHoSoByPhongBan(String maPhongBan);

	public void addHoSoNhanVien(HoSoNhanVienTT hsnv);

	public void updateHoSoNhanVien(HoSoNhanVienTT hsnv);

	public void deleteHoSoNhanVien(HoSoNhanVienTT hsnv);
	
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien);
	
	public List<HoSoNhanVienTT> viewOne(int maNhanVien);

}

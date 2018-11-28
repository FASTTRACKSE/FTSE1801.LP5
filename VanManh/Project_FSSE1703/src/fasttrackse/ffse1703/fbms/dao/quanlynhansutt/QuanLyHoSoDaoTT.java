package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;

public interface QuanLyHoSoDaoTT {
	public List<HoSoNhanVienTT> getAllHoSo();

	public List<HoSoNhanVienTT> getAllHoSo(int iDisplayStart, int iDisplayLength, String sql);

	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien);

	public List<HoSoNhanVienTT> getHoSoByPhongBan(String maPhongBan);

	public void addHoSoNhanVien(HoSoNhanVienTT hsnv);

	public void updateHoSoNhanVien(HoSoNhanVienTT hsnv);

	public void deleteHoSoNhanVien(HoSoNhanVienTT hsnv);
	
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien);
	
	public List<HoSoNhanVienTT> viewOne(int maNhanVien);
}

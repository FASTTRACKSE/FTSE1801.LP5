package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.PhongBanTT;

public interface QuanLyHopDongDaoTT {
	
	public String getRecordsTotal(String maPhongBan);

	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql);

	public List<HopDongTT> getAllHopDong(String search);

	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan);

	public void addHopDong(HopDongTT tt);

	public void updateHopDong(HopDongTT tt);
	
	public void removeHopDong(HopDongTT tt);
	
	public HopDongTT findByMaHopDong(int maHopDong);
	
	public List<HoSoNhanVienTT> getAllNhanVien();
	
public List<PhongBanTT> getAllPhongBan();
	
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien);
		
	public List<HopDongTT> viewOne(int maNhanVien);
	
	int checkloaiHopDong(String loaiHopDong, int maNhanVien);
	
}

package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.PhongBanTT;

public interface HopDongServiceTT {
	
	public List<HopDongTT> getAllHopDong(String search);

	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan);

	public void addHopDong(HopDongTT tt);

	public void updateHopDong(HopDongTT tt);
	
	public void removeHopDong(HopDongTT tt);

	public String getAutoId();

	public String getRecordsTotal(String maPhongBan);

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request, String maPhongBan);

	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql);

	public String toJson(HopDongTT hd);

	public Object findAllForPaging(int startPosition, int recordsPerPage);

	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien);

	public HopDongTT findByMaHopDong(int maHopDong);
	
	public List<HoSoNhanVienTT> getAllNhanVien();
	
	public List<PhongBanTT> getAllPhongBan();
	
	
	public List<HopDongTT> viewOne(int maNhanVien);

	int checkloaiHopDong(String maHopDong, int maNhanVien);
}

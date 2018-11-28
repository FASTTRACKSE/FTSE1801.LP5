package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;

public interface HopDongPikalongSevice {
	public List<HopDongPikalong> listHopDong();
	public void insert(HopDongPikalong hd);
	public void update(HopDongPikalong hd);
	public String getAutoId();
	public String getLastMaHd();
	public String getLastTrangThaiHd(String maNv);
	public HopDongPikalong getMaHopDong(int maHopDong);
	public HopDongPikalong getHopDongById(int maHopDong);
	public List<HopDongPikalong> viewOne(String maNv);
	List<HopDongPikalong> listHopDongByPhongBan(String phongBan);
	
}

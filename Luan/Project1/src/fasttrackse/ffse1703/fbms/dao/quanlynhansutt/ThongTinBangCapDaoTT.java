package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;

public interface ThongTinBangCapDaoTT {
	public List<ThongTinBangCapTT> ListBangCap();
	
	public void addThongTinBangCap(ThongTinBangCapTT ttbc);

	public void updateThongTinBangCap(ThongTinBangCapTT ttbc);

	public void deleteThongTinBangCap(ThongTinBangCapTT ttbc);
	
	public ThongTinBangCapTT findByBangCap(int id);
	
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien);
	
	public List<ThongTinBangCapTT> viewOne(int maNhanVien);

}

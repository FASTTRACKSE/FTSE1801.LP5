package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HopDong;

public interface HopDongDao {
	public List<HopDong> getAll();

	public List<HopDong> getByPaging(int fistResult, int maxResult);
	
	public HopDong findByMaNhanVien(int maNhanVien);

	public void addNew(HopDong hopDong);

	public void update(HopDong hopDong);

	public void delete(int id);
}

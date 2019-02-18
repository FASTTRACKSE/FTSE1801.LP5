package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HopDong;

public interface HopDongService {
	public List<HopDong> getAll();

	public List<HopDong> getByPaging(int fistResult, int maxResult);

	public List<HopDong> getByType(int maLoaiHopDong);

	public List<HopDong> findByMaNhanVien(int maNhanVien);

	public void addNew(HopDong hopDong);

	public void update(HopDong hopDong);

	public HopDong getById(int id);
}

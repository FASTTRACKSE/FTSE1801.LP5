package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

public interface HopDongDao {
	public List<HopDongDao> getAll();

	public List<HopDongDao> getByPaging(int fistResult, int maxResult);
	
	public HopDongDao findByMaNhanVien(int maNhanVien);

	public void addNew(ThongTinChungChi bangCap);

	public void update(ThongTinChungChi bangCap);

	public void delete(int id);
}

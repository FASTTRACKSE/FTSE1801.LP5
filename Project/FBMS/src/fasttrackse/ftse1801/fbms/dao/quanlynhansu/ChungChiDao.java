package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

public interface ChungChiDao {
	public List<ThongTinChungChi> getAll();

	public List<ThongTinChungChi> getByPaging(int fistResult, int maxResult);
	
	public List<ThongTinChungChi> findByMaNhanVien(int maNhanVien);

	public void addNew(ThongTinChungChi bangCap);

	public void update(ThongTinChungChi bangCap);

	public void delete(int id);
}

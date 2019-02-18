package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

public interface ThongTinChungChiDao {
	public List<ThongTinChungChi> getAll();

	public List<ThongTinChungChi> getByPaging(int fistResult, int maxResult);
	
	public List<ThongTinChungChi> findByMaNhanVien(int maNhanVien);

	public void addNew(ThongTinChungChi chungChi);

	public void update(ThongTinChungChi chungChi);

	public void delete(int id);
	
	public ThongTinChungChi getById(int id);
}

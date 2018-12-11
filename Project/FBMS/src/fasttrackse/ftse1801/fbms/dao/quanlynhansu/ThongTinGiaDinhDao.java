package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinGiaDinh;

public interface ThongTinGiaDinhDao {
	public List<ThongTinGiaDinh> getAll();

	public List<ThongTinGiaDinh> getByPaging(int fistResult, int maxResult);
	
	public List<ThongTinGiaDinh> findByMaNhanVien(int maNhanVien);

	public void addNew(ThongTinGiaDinh thongTinGiaDinh);

	public void update(ThongTinGiaDinh thongTinGiaDinh);

	public void delete(int id);
	
	public ThongTinGiaDinh getById(int id);
}

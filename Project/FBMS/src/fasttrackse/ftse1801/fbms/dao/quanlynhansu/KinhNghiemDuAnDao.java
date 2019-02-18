package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.KinhNghiemDuAn;

public interface KinhNghiemDuAnDao {
	public List<KinhNghiemDuAn> list();

	public List<KinhNghiemDuAn> getByPaging(int fistResult, int maxResult);

	public List<KinhNghiemDuAn> getByMaNhanVien(int maNhanVien);

	public void addNew(KinhNghiemDuAn kinhNghiemDuAn);

	public void update(KinhNghiemDuAn kinhNghiemDuAn);

	public KinhNghiemDuAn getById(int id);
}

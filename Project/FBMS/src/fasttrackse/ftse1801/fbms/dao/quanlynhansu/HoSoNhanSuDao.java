package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

public interface HoSoNhanSuDao {

	public List<HoSoNhanSu> getAll();

	public List<HoSoNhanSu> getByPaging(int fistResult, int maxResult);

	public HoSoNhanSu getById(int id);

	public List<HoSoNhanSu> getByPhongBan(String maPhongBan);

	public void addNew(HoSoNhanSu nhanVien);

	public void update(HoSoNhanSu nhanVien);

	public void delete(int id);

}

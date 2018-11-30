package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanVien;

public interface HoSoNhanVienDao {

	public List<HoSoNhanVien> getAll();

	public List<HoSoNhanVien> getByPaging(int fistResult, int maxResult);

	public HoSoNhanVien getById(int id);

	public List<HoSoNhanVien> getByPhongBan(String maPhongBan);

	public void addNew(HoSoNhanVien nhanVien);

	public void update(HoSoNhanVien nhanVien);

	public void delete(int id);

}

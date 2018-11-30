package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinBangCap;

public interface BangCapDao {
	
	public List<ThongTinBangCap> getAll();

	public List<ThongTinBangCap> getByPaging(int fistResult, int maxResult);
	
	public List<ThongTinBangCap> findByMaNhanVien(int maNhanVien);

	public void addNew(ThongTinBangCap bangCap);

	public void update(ThongTinBangCap bangCap);

	public void delete(int id);


}
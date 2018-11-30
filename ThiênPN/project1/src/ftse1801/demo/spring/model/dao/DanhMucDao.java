package ftse1801.demo.spring.model.dao;

import java.util.List;

import ftse1801.demo.spring.model.entity.DanhMucTaiLieu;

public interface DanhMucDao {
	public List<DanhMucTaiLieu> getAllDanhMuc();

	public List<DanhMucTaiLieu> getAllDanhMuc(int page, int record);

	public boolean insertDanhMuc(DanhMucTaiLieu danhMuc);

	public boolean updateDanhMuc(DanhMucTaiLieu danhMuc);

	public boolean deleteDanhMuc(String maDanhMuc);

	public DanhMucTaiLieu getDanhMucByMa(String maDanhMuc);
}

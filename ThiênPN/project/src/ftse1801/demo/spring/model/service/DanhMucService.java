package ftse1801.demo.spring.model.service;

import java.util.List;

import ftse1801.demo.spring.model.entity.DanhMucTaiLieu;

public interface DanhMucService {
	public List<DanhMucTaiLieu> getAllDanhMuc();

	public List<DanhMucTaiLieu> getAllDanhMuc(int page, int record);

	public void insertDanhMuc(DanhMucTaiLieu danhMuc);

	public void updateDanhMuc(DanhMucTaiLieu danhMuc);

	public void deleteDanhMuc(String maDanhMuc);

	public DanhMucTaiLieu getDanhMucByMa(String maDanhMuc);
}

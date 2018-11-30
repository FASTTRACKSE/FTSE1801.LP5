package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;

public interface DanhMucDao {
	public List<DanhMucTaiLieu> getAllDanhMuc();

	public List<DanhMucTaiLieu> getAllDanhMuc(int page, int record);

	public void insertDanhMuc(DanhMucTaiLieu danhMuc);

	public void updateDanhMuc(DanhMucTaiLieu danhMuc);

	public void deleteDanhMuc(String maDanhMuc);

	public DanhMucTaiLieu getDanhMucByMa(String maDanhMuc);
}

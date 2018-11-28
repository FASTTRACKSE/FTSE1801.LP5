package ftse1801.demo.spring.model.dao;

import java.util.List;

import ftse1801.demo.spring.model.entity.TrangThaiTaiLieu;

public interface TrangThaiDao {
	public List<TrangThaiTaiLieu> getAllTrangThai();

	public List<TrangThaiTaiLieu> getAllTrangThai(int page, int record);

	public boolean insertTrangThai(TrangThaiTaiLieu trangThai);

	public boolean updateTrangThai(TrangThaiTaiLieu trangThai);

	public boolean deleteTrangThai(String maTrangThai);

	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai);
}

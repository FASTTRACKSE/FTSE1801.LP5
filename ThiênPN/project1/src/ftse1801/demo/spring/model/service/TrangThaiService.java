package ftse1801.demo.spring.model.service;

import java.util.List;

import ftse1801.demo.spring.model.entity.TrangThaiTaiLieu;

public interface TrangThaiService {
	public List<TrangThaiTaiLieu> getAllTrangThai();

	public List<TrangThaiTaiLieu> getAllTrangThai(int page, int record);

	public void insertTrangThai(TrangThaiTaiLieu trangThai);

	public void updateTrangThai(TrangThaiTaiLieu trangThai);

	public void deleteTrangThai(String maTrangThai);

	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai);
}

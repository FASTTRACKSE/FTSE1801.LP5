package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;

public interface TrangThaiService {
	public List<TrangThaiTaiLieu> getAllTrangThai();

	public List<TrangThaiTaiLieu> getAllTrangThai(int page, int record);

	public void insertTrangThai(TrangThaiTaiLieu trangThai);

	public void updateTrangThai(TrangThaiTaiLieu trangThai);

	public void deleteTrangThai(String maTrangThai);

	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai);
}

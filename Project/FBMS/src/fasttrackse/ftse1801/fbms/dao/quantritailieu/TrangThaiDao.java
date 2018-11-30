package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;


public interface TrangThaiDao {
	public List<TrangThaiTaiLieu> getAllTrangThaiDel0();

	public List<TrangThaiTaiLieu> getAllTrangThaiDel1();

	public void insertTrangThai(TrangThaiTaiLieu trangThai);

	public void updateTrangThai(TrangThaiTaiLieu trangThai);

	public void deleteTrangThai(String maTrangThai);

	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai);
	public List<TaiLieu> getAllbyMaTT(String maTrangThai);
}

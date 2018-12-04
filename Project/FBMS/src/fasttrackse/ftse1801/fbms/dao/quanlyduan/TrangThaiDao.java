package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.TrangThai;

public interface TrangThaiDao {
	public List<TrangThai> findAll();
	public TrangThai findById(int maTrangThai);
	public void addNew(TrangThai trangThai);
	public void update(TrangThai trangThai);
	public void delete(TrangThai trangThai);
	public int checkNameTrangThai(String tenTrangThai);
	public List<TrangThai> listTrangThai(int start, int maxRows);
	public int countTrangThai() ;
}

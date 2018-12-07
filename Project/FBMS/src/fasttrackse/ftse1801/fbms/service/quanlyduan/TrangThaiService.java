package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.TrangThai;

public interface TrangThaiService {
	public List<TrangThai> findAll();
	public TrangThai findById(String maTrangThai);
	public void add(TrangThai trangThai);
	public void update(TrangThai trangThai);
	public void delete(TrangThai trangThai);
	public int checkTenTrangThai(String tenTrangThai);
	public List<TrangThai> listTrangThai(int start, int maxRows);
	public int countTrangThai() ;
}

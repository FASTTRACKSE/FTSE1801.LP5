package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.KhachHang;

public interface KhachHangDao {
	public KhachHang getById(String maKh);
	public List<KhachHang> getAll();
	public void update(KhachHang khachHang);
	public void delete(String maKh);
	public void add(KhachHang khachHang);
	public List<KhachHang> listKh(int start, int maxRows);
	public int countKhachHang() ;
	public int checkMaKhachHang(String maKH);

}

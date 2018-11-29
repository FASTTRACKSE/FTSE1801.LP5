package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

public interface KhachHangDao {
	
	public KhachHang getById(String id);
	public List<KhachHang> getAll();
	public void update(KhachHang khachHang);
	public void delete(String id);
	public void add(KhachHang khachHang);
	public List<KhachHang> listKhachHang(int start, int maxRows);
	public int countKhachHang() ;
	public int checkIdKhachHang(String idKhachHang);
	
	
}

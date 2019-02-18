package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;

public interface VaiTroThanhVienDao {
	public List<VaiTroThanhVien> findAll();
	public VaiTroThanhVien findById(String maVaiTro);
	public void add(VaiTroThanhVien vaiTroThanhVien);
	public void update(VaiTroThanhVien vaiTroThanhVien);
	public void delete(VaiTroThanhVien vaiTroThanhVien);
	public int checkTenVaiTro(String tenVaiTro);
	public List<VaiTroThanhVien> listVaiTro(int start, int maxRows);
	public int countVaiTro();
}

package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;

public interface VaiTroThanhVienDao {
	public List<VaiTroThanhVien> findAll();
	public VaiTroThanhVien findById(int maVaiTro);
	public void addNew(VaiTroThanhVien vaiTroThanhVien);
	public void update(VaiTroThanhVien vaiTroThanhVien);
	public void delete(VaiTroThanhVien vaiTroThanhVien);
	public int checkNameVaiTroThanhVien(String tenVaiTro);
	public List<VaiTroThanhVien> listRoles(int start, int maxRows);
	public int countVaiTroThanhVien();
}

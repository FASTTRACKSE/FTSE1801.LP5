package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public interface DuAnDao {
	public List<DuAn> findAll();
	public DuAn findById(int maDuAn);
	public void add(DuAn duAn);
	public void update(DuAn duAn);
	public void delete(DuAn duAn);
	public int checkTenDuAn(String tenDuAn);
	public int checkMaDuAn(int maDuAn);
	public List<HoSoNhanSu> getPm(String maPhongBan);
	public List<DuAn> listDuAn(String search, int start, int maxRows);
	public UserAccount getAccount(String userName);
}

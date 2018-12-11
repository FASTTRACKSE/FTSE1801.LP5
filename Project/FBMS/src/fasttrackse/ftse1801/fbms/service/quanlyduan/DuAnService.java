package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.HoSoNhanVien;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public interface DuAnService {
	public List<DuAn> findAll();
	public DuAn findById(String maDuAn);
	public void addNew(DuAn duAn);
	public void update(DuAn duAn);
	public void delete(DuAn duAn);
	public int checkNameProjects(String tenDuAn);
	public int checkMaProjects(String maDuAn);
	public List<HoSoNhanVien> getPm(String maPhongBan);
	public List<DuAn> listDuAn(String search,int start,int maxRows);
	public UserAccount getAccount(String userName);
	public int count(String search);
}

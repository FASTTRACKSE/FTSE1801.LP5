package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
<<<<<<< HEAD
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
=======
import fasttrackse.ftse1801.fbms.entity.quanlyduan.HoSoNhanVien;
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public interface DuAnService {
	public List<DuAn> findAll();
<<<<<<< HEAD
	public DuAn findById(int maDuAn);
	public void add(DuAn duAn);
	public void update(DuAn duAn);
	public void delete(DuAn duAn);
	public int checkTenDuAn(String tenDuAn);
	public int checkMaDuAn(int maDuAn);
	public List<HoSoNhanSu> getPm(String maPhongBan);
	public List<DuAn> listDuAn(String search, int start, int maxRows);
	public UserAccount getAccount(String userName);
=======
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
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
}

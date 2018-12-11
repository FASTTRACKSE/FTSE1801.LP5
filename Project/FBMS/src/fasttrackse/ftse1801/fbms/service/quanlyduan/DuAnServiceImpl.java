package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.DuAnDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
<<<<<<< HEAD
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
=======
import fasttrackse.ftse1801.fbms.entity.quanlyduan.HoSoNhanVien;
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

@Service
@Transactional
public class DuAnServiceImpl implements DuAnService {
	@Autowired
	private DuAnDao duAnDao;

<<<<<<< HEAD
=======
	public DuAnDao getDuAnDao() {
		return duAnDao;
	}

	public void setDuAnDao(DuAnDao duAnDao) {
		this.duAnDao = duAnDao;
	}

>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
	@Override
	public List<DuAn> findAll() {
		return duAnDao.findAll();
	}

	@Override
<<<<<<< HEAD
	public DuAn findById(int maDuAn) {
=======
	public DuAn findById(String maDuAn) {
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
		return duAnDao.findById(maDuAn);
	}

	@Override
<<<<<<< HEAD
	public void add(DuAn duAn) {
		duAnDao.add(duAn);
=======
	public void addNew(DuAn duAn) {
		duAnDao.addNew(duAn);
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
	}

	@Override
	public void update(DuAn duAn) {
		duAnDao.update(duAn);
	}

	@Override
	public void delete(DuAn duAn) {
		duAnDao.delete(duAn);
	}

	@Override
<<<<<<< HEAD
	public int checkTenDuAn(String tenDuAn) {
		return duAnDao.checkTenDuAn(tenDuAn);
	}

	@Override
	public int checkMaDuAn(int maDuAn) {
		return duAnDao.checkMaDuAn(maDuAn);
	}

	@Override
	public List<HoSoNhanSu> getPm(String maPhongBan) {
=======
	public int checkNameProjects(String tenDuAn) {
		return duAnDao.checkNameProjects(tenDuAn);
	}

	@Override
	public int checkMaProjects(String maDuAn) {
		return duAnDao.checkMaProjects(maDuAn);
	}

	@Override
	public List<HoSoNhanVien> getPm(String maPhongBan) {
>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
		return duAnDao.getPm(maPhongBan);
	}

	@Override
	public List<DuAn> listDuAn(String search, int start, int maxRows) {
		return duAnDao.listDuAn(search, start, maxRows);
	}

	@Override
	public UserAccount getAccount(String userName) {
		return duAnDao.getAccount(userName);
	}
<<<<<<< HEAD
	
=======

	@Override
	public int count(String search) {
		return duAnDao.count(search);
	}

>>>>>>> 1842461fe799b8a92deb9010a58b725a4f1aacc7
}

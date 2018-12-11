package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.DuAnDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.HoSoNhanVien;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

@Service
@Transactional
public class DuAnServiceImpl implements DuAnService {
	@Autowired
	private DuAnDao duAnDao;

	public DuAnDao getDuAnDao() {
		return duAnDao;
	}

	public void setDuAnDao(DuAnDao duAnDao) {
		this.duAnDao = duAnDao;
	}

	@Override
	public List<DuAn> findAll() {
		return duAnDao.findAll();
	}

	@Override
	public DuAn findById(String maDuAn) {
		return duAnDao.findById(maDuAn);
	}

	@Override
	public void addNew(DuAn duAn) {
		duAnDao.addNew(duAn);
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
	public int checkNameProjects(String tenDuAn) {
		return duAnDao.checkNameProjects(tenDuAn);
	}

	@Override
	public int checkMaProjects(String maDuAn) {
		return duAnDao.checkMaProjects(maDuAn);
	}

	@Override
	public List<HoSoNhanVien> getPm(String maPhongBan) {
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

}

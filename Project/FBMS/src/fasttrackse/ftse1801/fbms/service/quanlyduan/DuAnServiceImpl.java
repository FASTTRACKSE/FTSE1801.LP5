package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.DuAnDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

@Service
@Transactional
public class DuAnServiceImpl implements DuAnService {
	@Autowired
	private DuAnDao duAnDao;

	@Override
	public List<DuAn> findAll() {
		return duAnDao.findAll();
	}

	@Override
	public DuAn findById(int maDuAn) {
		return duAnDao.findById(maDuAn);
	}

	@Override
	public void add(DuAn duAn) {
		duAnDao.add(duAn);
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
	public int checkTenDuAn(String tenDuAn) {
		return duAnDao.checkTenDuAn(tenDuAn);
	}

	@Override
	public int checkMaDuAn(int maDuAn) {
		return duAnDao.checkMaDuAn(maDuAn);
	}

	@Override
	public List<HoSoNhanSu> getPm(String maPhongBan) {
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

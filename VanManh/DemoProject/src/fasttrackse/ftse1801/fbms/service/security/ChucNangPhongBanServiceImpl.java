package fasttrackse.ftse1801.fbms.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.security.ChucNangPhongBanDao;
import fasttrackse.ftse1801.fbms.entity.security.ChucNangPhongBan;

@Service
public class ChucNangPhongBanServiceImpl implements ChucNangPhongBanService {

	@Autowired
	private ChucNangPhongBanDao chucNangPhongBanDao;

	@Override
	public List<ChucNangPhongBan> findAll() {
		return chucNangPhongBanDao.findAll();
	}

	@Override
	public void addNew(ChucNangPhongBan cd) {
		chucNangPhongBanDao.addNew(cd);
	}

	@Override
	public void update(ChucNangPhongBan cd) {
		chucNangPhongBanDao.update(cd);
	}

	@Override
	public void delete(int id) {
		chucNangPhongBanDao.delete(id);
	}

	@Override
	public List<ChucNangPhongBan> findAllForPaging(int startPosition, int maxResult) {
		return chucNangPhongBanDao.findAllForPaging(startPosition, maxResult);
	}

	@Override
	public ChucNangPhongBan findById(int id) {
		return chucNangPhongBanDao.findById(id);
	}

}

package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.NgonNguDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.NgonNgu;
@Service
@Transactional
public class NgonNguServiceImpl implements NgonNguService{
@Autowired
private NgonNguDao ngonNguDao;
	@Override
	public List<NgonNgu> getAll() {
		return ngonNguDao.getAll();
	}

	@Override
	public NgonNgu getById(String maNgonNgu) {
		return ngonNguDao.getById(maNgonNgu);
	}

	@Override
	public void add(NgonNgu ngonNgu) {
		ngonNguDao.add(ngonNgu);		
	}

	@Override
	public void update(NgonNgu ngonNgu) {
		ngonNguDao.update(ngonNgu);		
	}

	@Override
	public void delete(String maNgonNgu) {
		ngonNguDao.delete(maNgonNgu);		
	}

	@Override
	public int checkName(String tenNgonNgu) {
		return ngonNguDao.checkNameLanguage(tenNgonNgu);
	}

	@Override
	public List<NgonNgu> listNgonNgu(int start, int maxRows) {
		return ngonNguDao.listNgonNgu(start, maxRows);
	}

	@Override
	public int countLanguage() {
		return ngonNguDao.countNgonNgu();
	}

	@Override
	public int checkMa(String maNgonNgu) {
		return ngonNguDao.checkMa(maNgonNgu);
	}

}

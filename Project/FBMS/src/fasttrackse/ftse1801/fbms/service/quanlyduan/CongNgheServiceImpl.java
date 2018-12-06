package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.CongNgheDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.CongNghe;
@Service
@Transactional
public class CongNgheServiceImpl implements CongNgheService{
@Autowired
private CongNgheDao congNgheDao;

	@Override
	public List<CongNghe> findAll() {
		return congNgheDao.findAll();
	}

	@Override
	public CongNghe findById(String maCongNghe) {
		return congNgheDao.findById(maCongNghe);
	}

	@Override
	public void addNew(CongNghe congNghe) {
		congNgheDao.addNew(congNghe);		
	}

	@Override
	public void update(CongNghe congNghe) {
		congNgheDao.update(congNghe);		
	}

	@Override
	public void delete(CongNghe congNghe) {
		congNgheDao.delete(congNghe);		
	}

	@Override
	public int checkNameCongNghe(String tenCongNghe) {
		return congNgheDao.checkNameCongNghe(tenCongNghe);
	}

	@Override
	public int checkMaCongNghe(String maCongNghe) {
		return congNgheDao.checkMaCongNghe(maCongNghe);
	}

	@Override
	public List<CongNghe> listCongNghe(int start, int maxRows) {
		return congNgheDao.listCongNghe(start, maxRows);
	}

	@Override
	public int countCongNghe() {
		return congNgheDao.countCongNghe();
	}

}

package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.TrangThaiDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.TrangThai;

@Service
@Transactional
public class TrangThaiServiceImpl implements TrangThaiService {

	@Autowired
	private TrangThaiDao trangThaiDao;

	public TrangThaiDao getTrangThaiDao() {
		return trangThaiDao;
	}

	public void setTrangThaiDao(TrangThaiDao trangThaiDao) {
		this.trangThaiDao = trangThaiDao;
	}

	@Override
	public List<TrangThai> findAll() {
		return trangThaiDao.findAll();
	}

	@Override
	public TrangThai findById(String maTrangThai) {
		return trangThaiDao.findById(maTrangThai);
	}

	@Override
	@Transactional
	public void add(TrangThai trangThai) {
		trangThaiDao.add(trangThai);
	}

	@Override
	@Transactional
	public void update(TrangThai trangThai) {
		trangThaiDao.update(trangThai);
	}

	@Override
	@Transactional
	public void delete(TrangThai trangThai) {
		trangThaiDao.delete(trangThai);
	}

	@Override
	public int checkTenTrangThai(String tenTrangThai) {
		return trangThaiDao.checkTenTrangThai(tenTrangThai);
	}

	@Override
	public List<TrangThai> listTrangThai(int start, int maxRows) {
		return trangThaiDao.listTrangThai(start, maxRows);
	}

	@Override
	@Transactional
	public int countTrangThai() {
		return trangThaiDao.countTrangThai();
	}

}

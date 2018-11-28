package ftse1801.demo.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftse1801.demo.spring.model.dao.TrangThaiDao;
import ftse1801.demo.spring.model.entity.TrangThaiTaiLieu;

public class TrangThaiServiceIMPL implements TrangThaiService {
	@Autowired
	TrangThaiDao trangThaiDao;

	@Override
	public List<TrangThaiTaiLieu> getAllTrangThai() {
		return trangThaiDao.getAllTrangThai();
	}

	@Override
	public List<TrangThaiTaiLieu> getAllTrangThai(int page, int record) {
		return trangThaiDao.getAllTrangThai(page, record);
	}

	@Override
	public void insertTrangThai(TrangThaiTaiLieu trangThai) {
		trangThaiDao.insertTrangThai(trangThai);
	}

	@Override
	public void updateTrangThai(TrangThaiTaiLieu trangThai) {
		trangThaiDao.updateTrangThai(trangThai);
	}

	@Override
	public void deleteTrangThai(String maTrangThai) {
		trangThaiDao.deleteTrangThai(maTrangThai);
	}

	@Override
	public TrangThaiTaiLieu getTrangThaibyMa(String maTrangThai) {
		return trangThaiDao.getTrangThaibyMa(maTrangThai);
	}

}

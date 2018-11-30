package ftse1801.demo.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftse1801.demo.spring.model.dao.DanhMucDao;
import ftse1801.demo.spring.model.entity.DanhMucTaiLieu;

public class DanhMucServiceIMPL implements DanhMucService {
	@Autowired
	DanhMucDao danhMucDao;

	@Override
	public List<DanhMucTaiLieu> getAllDanhMuc() {
		return danhMucDao.getAllDanhMuc();
	}

	@Override
	public List<DanhMucTaiLieu> getAllDanhMuc(int page, int record) {
		return danhMucDao.getAllDanhMuc(page, record);
	}

	@Override
	public void insertDanhMuc(DanhMucTaiLieu danhMuc) {
		danhMucDao.insertDanhMuc(danhMuc);
	}

	@Override
	public void updateDanhMuc(DanhMucTaiLieu danhMuc) {
		danhMucDao.updateDanhMuc(danhMuc);
	}

	@Override
	public void deleteDanhMuc(String maDanhMuc) {
		danhMucDao.deleteDanhMuc(maDanhMuc);
	}

	@Override
	public DanhMucTaiLieu getDanhMucByMa(String maDanhMuc) {
		return danhMucDao.getDanhMucByMa(maDanhMuc);
	}

}

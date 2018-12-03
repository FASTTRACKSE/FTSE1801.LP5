package fasttrackse.ftse1801.fbms.service.qlnhiemvu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftse1801.fbms.dao.qlnhiemvu.QuanLyNhiemVuDao;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThai;

@Service
public class QuanLyNhiemVuServiceImpl implements QuanLyNhiemVuService {
	
	@Autowired
	private QuanLyNhiemVuDao quanLyNhiemVuDao;

	@Override
	@Transactional
	public QuanLyNhiemVu findById(int id) {
		return this.quanLyNhiemVuDao.findById(id);
	}

	@Override
	@Transactional
	public void add(QuanLyNhiemVu qlnv) {
		this.quanLyNhiemVuDao.add(qlnv);
	}

	@Override
	@Transactional
	public void edit(QuanLyNhiemVu qlnv) {
		this.quanLyNhiemVuDao.edit(qlnv);
	}

	@Override
	@Transactional
	public void delete(QuanLyNhiemVu qlnv) {
		this.quanLyNhiemVuDao.delete(qlnv);
	}

	@Override
	public List<QuanLyNhiemVu> getAll() {
		return this.quanLyNhiemVuDao.getAll();
	}

	@Override
	public List<TrangThai> trangThai() {
		return this.quanLyNhiemVuDao.trangThai();
	}

	@Override
	public List<LoaiCongViec> loaiCongViec() {
		return this.quanLyNhiemVuDao.loaiCongViec();
	}

//	@Override
//	public List<DuAn> duAn() {
//		return this.qlNhiemVuDao.duAn();
//	}
//
//	@Override
//	public List<VaiTro> vaiTro() {
//		return this.qlNhiemVuDao.vaiTro();
//	}

	@Override
	public List<QuanLyNhiemVu> getAllpage(int page, int size) {
		return this.quanLyNhiemVuDao.getAllpage(page, size);
	}

	@Override
	public List<QuanLyNhiemVu> searchAll(String search) {
		return this.quanLyNhiemVuDao.searchAll(search);
	}

}

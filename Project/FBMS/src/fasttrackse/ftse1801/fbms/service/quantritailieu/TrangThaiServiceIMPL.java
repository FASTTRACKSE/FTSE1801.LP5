package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.dao.quantritailieu.TrangThaiDao;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;

public class TrangThaiServiceIMPL implements TrangThaiService {
	@Autowired
	TrangThaiDao trangThaiDao;

	@Override
	public List<TrangThaiTaiLieu> getAllTrangThaiDel0() {
		return trangThaiDao.getAllTrangThaiDel0();
	}

	@Override
	public List<TrangThaiTaiLieu> getAllTrangThaiDel1() {
		return trangThaiDao.getAllTrangThaiDel1();
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

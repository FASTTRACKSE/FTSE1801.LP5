package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quantritailieu.TaiLieuDao;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Service
public class TaiLieuServiceIMPL implements TaiLieuService {
	@Autowired
	private TaiLieuDao taiLieuDao;

	@Override
	public List<TaiLieu> getAllTaiLieuDel0() {
		return taiLieuDao.getAllTaiLieuDel0();
	}

	@Override
	public List<TaiLieu> getAllTaiLieuDel1() {
		return taiLieuDao.getAllTaiLieuDel1();
	}

	@Override
	public void insertTaiLieu(TaiLieu tl) {
		taiLieuDao.insertTaiLieu(tl);

	}

	@Override
	public void updateTaiLieu(TaiLieu tl) {
		taiLieuDao.updateTaiLieu(tl);
	}

	@Override
	public void deleteTaiLieu(int maTL) {
		taiLieuDao.deleteTaiLieu(maTL);
	}

	@Override
	public TaiLieu getTaiLieuByMa(int maTL) {

		return taiLieuDao.getTaiLieuByMa(maTL);
	}

	@Override
	public List<TaiLieu> getAllTaiLieuDel0(int page, int record) {
		return taiLieuDao.getAllTaiLieuDel0(page, record);

	}

	@Override
	public List<TaiLieu> getAllTaiLieuDel1(int page, int record) {
		return taiLieuDao.getAllTaiLieuDel1(page, record);
	}

	@Override
	public List<DanhMucTaiLieu> listDanhMuc() {
		return taiLieuDao.listDanhMuc();
	}

	@Override
	public List<PhongBan> listPhongBan() {
		return taiLieuDao.listPhongBan();
	}

}

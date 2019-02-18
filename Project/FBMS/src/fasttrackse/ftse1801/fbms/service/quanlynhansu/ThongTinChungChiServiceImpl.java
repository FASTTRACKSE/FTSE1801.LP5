package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.ThongTinChungChiDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

@Service
public class ThongTinChungChiServiceImpl implements ThongTinChungChiService {
	@Autowired
	private ThongTinChungChiDao thongTinChungChiDao;
	
	@Override
	public List<ThongTinChungChi> getAll() {
		return thongTinChungChiDao.getAll();
	}

	@Override
	public List<ThongTinChungChi> getByPaging(int fistResult, int maxResult) {
		return thongTinChungChiDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<ThongTinChungChi> findByMaNhanVien(int maNhanVien) {
		return thongTinChungChiDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(ThongTinChungChi chungChi) {
		thongTinChungChiDao.addNew(chungChi);
	}

	@Override
	public void update(ThongTinChungChi chungChi) {
		thongTinChungChiDao.update(chungChi);
	}

	@Override
	public void delete(int id) {
		thongTinChungChiDao.delete(id);
	}

	@Override
	public ThongTinChungChi getById(int id) {
		return thongTinChungChiDao.getById(id);
	}

}

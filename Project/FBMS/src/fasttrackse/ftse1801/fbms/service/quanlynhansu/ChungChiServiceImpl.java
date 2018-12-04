package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.ChungChiDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

@Service
public class ChungChiServiceImpl implements ChungChiService {
	@Autowired
	private ChungChiDao chungChiDao;
	
	@Override
	public List<ThongTinChungChi> getAll() {
		return chungChiDao.getAll();
	}

	@Override
	public List<ThongTinChungChi> getByPaging(int fistResult, int maxResult) {
		return chungChiDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<ThongTinChungChi> findByMaNhanVien(int maNhanVien) {
		return chungChiDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(ThongTinChungChi chungChi) {
		chungChiDao.addNew(chungChi);
	}

	@Override
	public void update(ThongTinChungChi chungChi) {
		chungChiDao.update(chungChi);
	}

	@Override
	public void delete(int id) {
		chungChiDao.delete(id);
	}

}

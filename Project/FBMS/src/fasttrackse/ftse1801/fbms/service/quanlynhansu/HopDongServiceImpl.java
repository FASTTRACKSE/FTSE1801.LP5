package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.HopDongDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HopDong;

@Service
public class HopDongServiceImpl implements HopDongService{
	@Autowired
	private HopDongDao hopDongDao;
	
	@Override
	public List<HopDong> getAll() {
		return hopDongDao.getAll();
	}

	@Override
	public List<HopDong> getByPaging(int fistResult, int maxResult) {
		return hopDongDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<HopDong> getByType(int maLoaiHopDong) {
		return hopDongDao.getByType(maLoaiHopDong);
	}

	@Override
	public List<HopDong> findByMaNhanVien(int maNhanVien) {
		return hopDongDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(HopDong hopDong) {
		hopDongDao.addNew(hopDong);
	}

	@Override
	public void update(HopDong hopDong) {
		hopDongDao.update(hopDong);
	}

	@Override
	public HopDong getById(int id) {
		return hopDongDao.getById(id);
	}

}

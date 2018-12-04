package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.BangCapDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinBangCap;

@Service
public class BangCapServiceImpl implements BangCapService{
	@Autowired
	private BangCapDao bangCapDao;
	
	@Override
	public List<ThongTinBangCap> getAll() {
		return bangCapDao.getAll();
	}

	@Override
	public List<ThongTinBangCap> getByPaging(int fistResult, int maxResult) {
		return bangCapDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<ThongTinBangCap> findByMaNhanVien(int maNhanVien) {
		return bangCapDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(ThongTinBangCap bangCap) {
		bangCapDao.addNew(bangCap);
	}

	@Override
	public void update(ThongTinBangCap bangCap) {
		bangCapDao.update(bangCap);
	}

	@Override
	public void delete(int id) {
		bangCapDao.delete(id);
	}

}

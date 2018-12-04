package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.ThongTinBangCapDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinBangCap;

@Service
public class ThongTinBangCapServiceImpl implements ThongTinBangCapService{
	@Autowired
	private ThongTinBangCapDao thongTinBangCapDao;
	
	@Override
	public List<ThongTinBangCap> getAll() {
		return thongTinBangCapDao.getAll();
	}

	@Override
	public List<ThongTinBangCap> getByPaging(int fistResult, int maxResult) {
		return thongTinBangCapDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<ThongTinBangCap> findByMaNhanVien(int maNhanVien) {
		return thongTinBangCapDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(ThongTinBangCap bangCap) {
		thongTinBangCapDao.addNew(bangCap);
	}

	@Override
	public void update(ThongTinBangCap bangCap) {
		thongTinBangCapDao.update(bangCap);
	}

	@Override
	public void delete(int id) {
		thongTinBangCapDao.delete(id);
	}

}

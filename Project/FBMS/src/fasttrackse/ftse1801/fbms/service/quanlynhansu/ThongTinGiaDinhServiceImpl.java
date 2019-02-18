package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.ThongTinGiaDinhDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinGiaDinh;

@Service
public class ThongTinGiaDinhServiceImpl implements ThongTinGiaDinhService{
	@Autowired
	private ThongTinGiaDinhDao thongTinGiaDinhDao;

	@Override
	public List<ThongTinGiaDinh> getAll() {
		return thongTinGiaDinhDao.getAll();
	}

	@Override
	public List<ThongTinGiaDinh> getByPaging(int fistResult, int maxResult) {
		return thongTinGiaDinhDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<ThongTinGiaDinh> findByMaNhanVien(int maNhanVien) {
		return thongTinGiaDinhDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(ThongTinGiaDinh thongTinGiaDinh) {
		thongTinGiaDinhDao.addNew(thongTinGiaDinh);
	}

	@Override
	public void update(ThongTinGiaDinh thongTinGiaDinh) {
		thongTinGiaDinhDao.update(thongTinGiaDinh);
	}

	@Override
	public void delete(int id) {
		thongTinGiaDinhDao.delete(id);
	}

	@Override
	public ThongTinGiaDinh getById(int id) {
		return thongTinGiaDinhDao.getById(id);
	}
	
	
}

package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.HoSoNhanSuDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

@Service
public class HoSoNhanSuServiceImpl implements HoSoNhanSuService{
	@Autowired
	private HoSoNhanSuDao hoSoNhanSuDao;
	
	@Override
	public List<HoSoNhanSu> getAll() {
		return hoSoNhanSuDao.getAll();
	}

	@Override
	public List<HoSoNhanSu> getByPaging(int fistResult, int maxResult) {
		return hoSoNhanSuDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public HoSoNhanSu getById(int id) {
		return hoSoNhanSuDao.getById(id);
	}

	@Override
	public List<HoSoNhanSu> getByPhongBan(String maPhongBan) {
		return hoSoNhanSuDao.getByPhongBan(maPhongBan);
	}

	@Override
	public void addNew(HoSoNhanSu nhanVien) {
		hoSoNhanSuDao.addNew(nhanVien);
	}

	@Override
	public void update(HoSoNhanSu nhanVien) {
		hoSoNhanSuDao.update(nhanVien);
	}

	@Override
	public void delete(int id) {
		hoSoNhanSuDao.delete(id);
	}

}

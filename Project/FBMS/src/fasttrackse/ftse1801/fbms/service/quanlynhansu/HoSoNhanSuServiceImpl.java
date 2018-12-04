package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.HoSoNhanSuDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

@Service
public class HoSoNhanSuServiceImpl implements HoSoNhanSuService{
	@Autowired
	private HoSoNhanSuDao hoSoNhanVienDao;
	
	@Override
	public List<HoSoNhanSu> getAll() {
		return hoSoNhanVienDao.getAll();
	}

	@Override
	public List<HoSoNhanSu> getByPaging(int fistResult, int maxResult) {
		return hoSoNhanVienDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public HoSoNhanSu getById(int id) {
		return hoSoNhanVienDao.getById(id);
	}

	@Override
	public List<HoSoNhanSu> getByPhongBan(String maPhongBan) {
		return hoSoNhanVienDao.getByPhongBan(maPhongBan);
	}

	@Override
	public void addNew(HoSoNhanSu nhanVien) {
		hoSoNhanVienDao.addNew(nhanVien);
	}

	@Override
	public void update(HoSoNhanSu nhanVien) {
		hoSoNhanVienDao.update(nhanVien);
	}

	@Override
	public void delete(int id) {
		hoSoNhanVienDao.delete(id);
	}

}

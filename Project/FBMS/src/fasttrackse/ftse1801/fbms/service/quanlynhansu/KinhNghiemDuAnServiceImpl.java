package fasttrackse.ftse1801.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlynhansu.KinhNghiemDuAnDao;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.KinhNghiemDuAn;

@Service
public class KinhNghiemDuAnServiceImpl implements KinhNghiemDuAnService{
	@Autowired
	private KinhNghiemDuAnDao kinhNghiemDuAnDao;

	@Override
	public List<KinhNghiemDuAn> list() {
		return kinhNghiemDuAnDao.list();
	}

	@Override
	public List<KinhNghiemDuAn> getByPaging(int fistResult, int maxResult) {
		return kinhNghiemDuAnDao.getByPaging(fistResult, maxResult);
	}

	@Override
	public List<KinhNghiemDuAn> getByMaNhanVien(int maNhanVien) {
		return kinhNghiemDuAnDao.getByMaNhanVien(maNhanVien);
	}

	@Override
	public void addNew(KinhNghiemDuAn kinhNghiemDuAn) {
		kinhNghiemDuAnDao.addNew(kinhNghiemDuAn);
	}

	@Override
	public void update(KinhNghiemDuAn kinhNghiemDuAn) {
		kinhNghiemDuAnDao.update(kinhNghiemDuAn);
	}

	@Override
	public KinhNghiemDuAn getById(int id) {
		return kinhNghiemDuAnDao.getById(id);
	}
}

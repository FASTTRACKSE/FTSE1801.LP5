package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.NhiemVuDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;

@Service
@Transactional
public class NhiemVuServiceImpl implements NhiemVuService{
	
	@Autowired
	private NhiemVuDao nhiemvuDao;

	@Override
	public NhiemVu getByMaDuAn(int maDuAn) {
		return nhiemvuDao.getByMaDuAn(maDuAn);
	}

	@Override
	public NhiemVu getByMaNhiemVu(int maNhiemVu) {
		return nhiemvuDao.getByMaNhiemVu(maNhiemVu);
	}

	@Override
	public List<NhiemVu> getByMaNhanVien(int maNhanVien) {
		return nhiemvuDao.getByMaNhanVien(maNhanVien);
	}

	@Override
	public List<NhiemVu> getByDuAn(int maDuAn) {
		return nhiemvuDao.getByDuAn(maDuAn);
	}

	@Override
	public List<NhiemVu> getByDuAn(int maDuAn, String search, int start, int maxRows) {
		return nhiemvuDao.getByDuAn(maDuAn, search, start, maxRows);
	}

	@Override
	public void add(NhiemVu nhiemVu) {
		nhiemvuDao.add(nhiemVu);
	}

	@Override
	public void update(NhiemVu nhiemVu) {
		nhiemvuDao.update(nhiemVu);
	}

	@Override
	public void delete(int maNhiemVu) {
		nhiemvuDao.delete(maNhiemVu);
	}

	@Override
	public int countNhiemvu(int maDuAn, String search) {
		return nhiemvuDao.countNhiemvu(maDuAn, search);
	}

	@Override
	public int checkVaiTro(int maNhanVien, String maVaiTro, int maDuAn) {
		return nhiemvuDao.checkVaiTro(maNhanVien, maVaiTro, maDuAn);
	}
	
}

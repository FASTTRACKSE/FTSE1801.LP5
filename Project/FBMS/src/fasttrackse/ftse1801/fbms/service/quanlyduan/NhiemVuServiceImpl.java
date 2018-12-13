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
	

	public NhiemVuDao getNhiemvuDao() {
		return nhiemvuDao;
	}

	public void setNhiemvuDao(NhiemVuDao nhiemvuDao) {
		this.nhiemvuDao = nhiemvuDao;
	}

	@Override
	public void add(NhiemVu nhiemVu) {
		nhiemvuDao.add(nhiemVu);		
	}

	@Override
	public NhiemVu getByID(String maDuAn) {
		return nhiemvuDao.getByID(maDuAn);
	}

	@Override
	public NhiemVu getByid(int maNhiemVu) {
		return nhiemvuDao.getByid(maNhiemVu);
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn) {
		return nhiemvuDao.getByDuAn(maDuAn);
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn, String search, int start, int maxRows) {
		return nhiemvuDao.getByDuAn(maDuAn, search, start, maxRows);
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
	public List<NhiemVu> getByMaNhanVien(int maNhanVien) {
		return nhiemvuDao.getByMaNhanVien(maNhanVien);
	}

	@Override
	public int countNhiemvu(String maDuAn, String search) {
		return nhiemvuDao.countNhiemvu(maDuAn, search);
	}

	@Override
	public int checkVaiTro(int maNhanVien, String maVaiTro, String maDuAn) {
		return nhiemvuDao.checkVaiTro(maNhanVien, maVaiTro, maDuAn);
	}

}

package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.KhachHangDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.KhachHang;

@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangDao khachHangDao;

	@Override
	public KhachHang getById(String maKh) {
		return khachHangDao.getById(maKh);
	}

	@Override
	public List<KhachHang> getAll() {
		return khachHangDao.getAll();
	}

	@Override
	public void update(KhachHang khachHang) {
		khachHangDao.update(khachHang);
	}

	@Override
	public void delete(String maKh) {
		khachHangDao.delete(maKh);		
	}

	@Override
	public void add(KhachHang khachHang) {
		khachHangDao.add(khachHang);		
	}

	@Override
	public List<KhachHang> listKh(int start, int maxRows) {
		return khachHangDao.listKh(start, maxRows);
	}

	@Override
	public int countKhachHang() {
		return khachHangDao.countKhachHang();
	}

	@Override
	public int checkMaKhachHang(String maKH) {
		return khachHangDao.checkMaKhachHang(maKH);
	}
	
	
	
}

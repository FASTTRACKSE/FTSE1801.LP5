package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.KhachHangDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangDao khachHangDao;

	@Override
	public void add(KhachHang khachHang) {
		this.khachHangDao.add(khachHang);
	}

	@Override
	public KhachHang getById(String id) {
		return this.khachHangDao.getById(id);
	}

	@Override
	public List<KhachHang> getAll() {
		return this.khachHangDao.getAll();
	}

	@Override
	public void update(KhachHang khachHang) {
		this.khachHangDao.update(khachHang);

	}

	@Override
	public void delete(String id) {
		this.khachHangDao.delete(id);

	}

	@Override
	public List<KhachHang> listKhachHang(int start, int maxRows) {
		
		return khachHangDao.listKhachHang(start, maxRows);
	}

	@Override
	public int countKhachHang() {
		return khachHangDao.countKhachHang();
	}

	@Override
	public int checkIdKhachHang(String idKhachHang) {
				return khachHangDao.checkIdKhachHang(idKhachHang);
	}

}

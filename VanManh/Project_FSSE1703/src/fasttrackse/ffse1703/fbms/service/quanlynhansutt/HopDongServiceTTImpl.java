package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanLyHopDongDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.PhongBanTT;

@Service
public class HopDongServiceTTImpl implements HopDongServiceTT {
	@Autowired
	private QuanLyHopDongDaoTT quanLyHopDongDaoTT;

	@Override
	@Transactional
	public List<HopDongTT> getAllHopDong(String search) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.getAllHopDong(search);
	}

	@Override
	@Transactional
	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.getHopDongByPhongBan(maPhongBan);
	}

	@Override
	@Transactional
	public void addHopDong(HopDongTT tt) {
		// TODO Auto-generated method stub
		quanLyHopDongDaoTT.addHopDong(tt);

	}

	@Override
	@Transactional
	public void updateHopDong(HopDongTT tt) {
		quanLyHopDongDaoTT.updateHopDong(tt);

	}
	
	@Override
	@Transactional
	public void removeHopDong(HopDongTT tt) {
		// TODO Auto-generated method stub
		quanLyHopDongDaoTT.removeHopDong(tt);
	}

	@Override
	public String getAutoId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQL(HttpServletRequest request, String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson(HopDongTT hd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findAllForPaging(int startPosition, int recordsPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.findByMaNhanVien(maNhanVien);
	}

	public HopDongServiceTTImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public HopDongTT findByMaHopDong(int maHopDong) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.findByMaHopDong(maHopDong);
	}

	@Transactional
	public List<HoSoNhanVienTT> getAllNhanVien() {
		return this.quanLyHopDongDaoTT.getAllNhanVien();
	}

	@Override
	@Transactional
	public List<HopDongTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.viewOne(maNhanVien);
	}

	@Override
	@Transactional
	public int checkloaiHopDong(String maHopDong, int maNhanVien) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.checkloaiHopDong(maHopDong, maNhanVien);
	}

	@Override
	@Transactional
	public List<PhongBanTT> getAllPhongBan() {
		return this.quanLyHopDongDaoTT.getAllPhongBan();
	}



}

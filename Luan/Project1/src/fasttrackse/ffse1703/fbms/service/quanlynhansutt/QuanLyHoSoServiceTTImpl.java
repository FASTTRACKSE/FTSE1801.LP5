package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanLyHoSoDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;

@Service
public class QuanLyHoSoServiceTTImpl implements QuanLyHoSoServiceTT {

	@Autowired
	private QuanLyHoSoDaoTT quanLyHoSoDaoTT;

	@Override
	@Transactional
	public List<HoSoNhanVienTT> getAllHoSo() {
		// TODO Auto-generated method stub
		return this.quanLyHoSoDaoTT.getAllHoSo();
	}

	@Override
	@Transactional
	public List<HoSoNhanVienTT> getAllHoSo(int iDisplayStart, int iDisplayLength, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSQL(HttpServletRequest request, String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<HoSoNhanVienTT> getHoSoByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void addHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub
		quanLyHoSoDaoTT.addHoSoNhanVien(hsnv);
	}
	@Override
	@Transactional
	public void updateHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub
		quanLyHoSoDaoTT.updateHoSoNhanVien(hsnv);
	}
	@Override
	@Transactional
	public void deleteHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub
            quanLyHoSoDaoTT.deleteHoSoNhanVien(hsnv);
	}

	@Override
	@Transactional
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.quanLyHoSoDaoTT.findByMaNhanVien(maNhanVien);
	}

	@Override
	public List<HoSoNhanVienTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.quanLyHoSoDaoTT.viewOne(maNhanVien);
	}

}

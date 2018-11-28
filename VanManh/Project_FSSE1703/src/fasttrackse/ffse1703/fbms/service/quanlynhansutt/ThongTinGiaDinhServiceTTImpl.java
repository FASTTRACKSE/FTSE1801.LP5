package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.ThongTinGiaDinhDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

@Service
public class ThongTinGiaDinhServiceTTImpl implements ThongTinGiaDinhServiceTT {
	
	@Autowired
	private ThongTinGiaDinhDaoTT thongTinGiaDinhDaoTT;

	@Override
	@Transactional
	public void addGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		thongTinGiaDinhDaoTT.addGiaDinh(p);
	}

	@Override
	@Transactional
	public void updateGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		thongTinGiaDinhDaoTT.updateGiaDinh(p);
	}

	@Override
	@Transactional
	public void removeGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		thongTinGiaDinhDaoTT.removeGiaDinh(p);
	}
	
	@Override
	@Transactional
	public ThongTinGiaDinhTT getGiaDinhById(int id) {
		// TODO Auto-generated method stub
		return this.thongTinGiaDinhDaoTT.getGiaDinhById(id);
	}


	@Override
	@Transactional
	public List<ThongTinGiaDinhTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.thongTinGiaDinhDaoTT.viewOne(maNhanVien);
	}

	@Override
	@Transactional
	public int checkQuanHe(String quanHe, int maNhanVien) {
		// TODO Auto-generated method stub
		return this.thongTinGiaDinhDaoTT.checkQuanHe(quanHe, maNhanVien);
				
	}

	@Override
	@Transactional
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return  this.thongTinGiaDinhDaoTT.findByMaNhanVien(maNhanVien);
	}


}

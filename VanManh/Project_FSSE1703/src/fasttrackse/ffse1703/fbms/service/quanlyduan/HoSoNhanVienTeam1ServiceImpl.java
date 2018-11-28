package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import org.springframework.transaction.annotation.Transactional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.HoSoNhanVienTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.HoSoNhanVienTeam1;

@Service
public class HoSoNhanVienTeam1ServiceImpl implements HoSoNhanVienTeam1Service {
	@Autowired
	HoSoNhanVienTeam1Dao hoSoNhanVienTeam1Dao;

	@Transactional
	@Override
	public List<HoSoNhanVienTeam1> findAll(String phongBan) {
		return hoSoNhanVienTeam1Dao.findAll(phongBan);

	}
	@Transactional
	@Override
	public List<HoSoNhanVienTeam1> getAll() {
		return hoSoNhanVienTeam1Dao.getAll();
	}
	@Transactional
	@Override
	public HoSoNhanVienTeam1 getById(int maNhanVien) {
		return hoSoNhanVienTeam1Dao.getById(maNhanVien);
	}

}

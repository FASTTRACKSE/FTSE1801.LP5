package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.NhiemVuTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.NhiemVuTeam1;

@Service
public class NhiemVuTeam1ServiceImpl implements NhiemVuTeam1Service {

	@Autowired
	NhiemVuTeam1Dao nhiemVuDao;

	@Override
	@Transactional
	public void save(NhiemVuTeam1 nhiemVu) {
		this.nhiemVuDao.save(nhiemVu);

	}

	@Override
	@Transactional
	public void update(NhiemVuTeam1 nhiemVu, NhiemVuTeam1 oldNhiemVu) {
		this.nhiemVuDao.update(nhiemVu, oldNhiemVu);

	}

	@Override
	@Transactional
	public List<NhiemVuTeam1> getAll(String maDuAn) {
		return this.nhiemVuDao.getAll(maDuAn);
	}

	@Override
	@Transactional
	public List<NhiemVuTeam1> getById(String maDuAn, int maNhanVien) {
		return this.nhiemVuDao.getById(maDuAn, maNhanVien);
	}

	@Override
	@Transactional
	public NhiemVuTeam1 getDetailNhiemVu(String maDuAn, int maNhanVien, String maVaiTro) {
		return this.nhiemVuDao.getDetailNhiemVu(maDuAn, maNhanVien, maVaiTro);
	}

	@Override
	@Transactional
	public void delete(NhiemVuTeam1 nhiemvu) {
		this.nhiemVuDao.delete(nhiemvu);
	}

}

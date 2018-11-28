package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.HopDongPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;

@Service
public class HopDongPikalongSeviceImpl implements HopDongPikalongSevice {
	@Autowired
	private HopDongPikalongDao  hopDongPikalongDao;

	public HopDongPikalongDao getHopDongPikalongDao() {
		return hopDongPikalongDao;
	}

	public void setHopDongPikalongDao(HopDongPikalongDao hopDongPikalongDao) {
		this.hopDongPikalongDao = hopDongPikalongDao;
	}
	
	@Override
	@Transactional
	public List<HopDongPikalong> listHopDong() {
		return this.hopDongPikalongDao.listHopDong();
	}
	
	@Override
	@Transactional
	public void insert(HopDongPikalong hd) {
		 this.hopDongPikalongDao.insert(hd);
	}
	
	@Override
	@Transactional
	public void update(HopDongPikalong hd) {
		this.hopDongPikalongDao.update(hd);
	}
	
	@Override
	@Transactional
	public String getAutoId() {
		return this.hopDongPikalongDao.getAutoId();
	}
	
	@Override
	@Transactional
	public String getLastMaHd() {
		return this.hopDongPikalongDao.getLastMaHd();
	}
	
	@Override
	@Transactional
	public String getLastTrangThaiHd(String maNv) {
		return this.hopDongPikalongDao.getLastTrangThaiHd(maNv);
	}
	
	@Override 
	@Transactional
	public HopDongPikalong getMaHopDong(int maHopDong) {
		return this.hopDongPikalongDao.getMaHopDong(maHopDong);
	}
	
	@Override
	@Transactional
	public HopDongPikalong getHopDongById(int maHopDong) {
		return this.hopDongPikalongDao.getHopDongById(maHopDong);
	}

	@Override
	@Transactional
	public List<HopDongPikalong> viewOne(String maNv) {
		return this.hopDongPikalongDao.viewOne(maNv);
	}

	@Override
	@Transactional
	public List<HopDongPikalong> listHopDongByPhongBan(String phongBan) {
		
		return hopDongPikalongDao.listHopDongByPhongBan(phongBan);
	}

}

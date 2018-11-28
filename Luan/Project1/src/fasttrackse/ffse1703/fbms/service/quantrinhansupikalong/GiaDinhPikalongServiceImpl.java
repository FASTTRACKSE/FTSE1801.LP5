package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.GiaDinhPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.GiaDinhPikalong;

@Service
public class GiaDinhPikalongServiceImpl implements GiaDinhPikalongService {
	@Autowired
	private GiaDinhPikalongDao giaDinhPikalongDao;

	public void setGiaDinhPikalongDao(GiaDinhPikalongDao giaDinhPikalongDao) {
		this.giaDinhPikalongDao = giaDinhPikalongDao;
	}

	@Override
	@Transactional
	public void addGiaDinhPikalong(GiaDinhPikalong p) {
		this.giaDinhPikalongDao.addGiaDinhPikalong(p);

	}

	@Override
	@Transactional
	public void updateGiaDinhPikalong(GiaDinhPikalong p) {
		this.giaDinhPikalongDao.updateGiaDinhPikalong(p);
	}

	@Override
	@Transactional
	public GiaDinhPikalong getGiaDinhPikalongById(int id) {
		return this.giaDinhPikalongDao.getGiaDinhPikalongById(id);
	}

	@Override
	@Transactional
	public void removeGiaDinhPikalong(int id) {
		this.giaDinhPikalongDao.removeGiaDinhPikalong(id);

	}

	@Override
	@Transactional
	public List<GiaDinhPikalong> viewOne(String maNV) {
		// TODO Auto-generated method stub
		return this.giaDinhPikalongDao.viewOne(maNV);
	}

	@Override
	@Transactional
	public int checkQuanHe(String quanHe, String maNV) {
		return this.giaDinhPikalongDao.checkQuanHe(quanHe, maNV);
	}

}

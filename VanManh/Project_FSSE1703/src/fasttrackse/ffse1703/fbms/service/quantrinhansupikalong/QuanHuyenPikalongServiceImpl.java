package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.QuanHuyenPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.QuanHuyenPikalong;

@Service
public class QuanHuyenPikalongServiceImpl implements QuanHuyenPikalongService {
	@Autowired
	private QuanHuyenPikalongDao quanHuyenPikalongDao;
	
	public void setQuanHuyenPikalongDao(QuanHuyenPikalongDao quanHuyenPikalongDao) {
		this.quanHuyenPikalongDao = quanHuyenPikalongDao;
	}



	@Override
	@Transactional
	public List<QuanHuyenPikalong> listQuanHuyen(String maThanhPho) {
		return quanHuyenPikalongDao.listQuanHuyen(maThanhPho);
	}

}

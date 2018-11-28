package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.ThanhPhoPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.ThanhPhoPikalong;

@Service
public class ThanhPhoPikalongServiceImpl implements ThanhPhoPikalongService {

	@Autowired
	
	ThanhPhoPikalongDao thanhPhoPikalongDao;
	
	public void setThanhPhoPikalongDao(ThanhPhoPikalongDao thanhPhoPikalongDao) {
		this.thanhPhoPikalongDao = thanhPhoPikalongDao;
	}



	@Override
	@Transactional
	public List<ThanhPhoPikalong> listTinhThanh() {
		
		return thanhPhoPikalongDao.listTinhThanh();
	}
	
}

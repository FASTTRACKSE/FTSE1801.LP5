package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.PhuongPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.PhuongPikalong;

@Service
public class PhuongPikalongServiceImpl  implements PhuongPikalongService{
	@Autowired
	private PhuongPikalongDao phuongPikalongDao;

	public void setPhuongPikalongDao(PhuongPikalongDao phuongPikalongDao) {
		this.phuongPikalongDao = phuongPikalongDao;
	}


	@Override
	@Transactional
	public List<PhuongPikalong> listPhuong(String maQuanHuyen) {
		
		return phuongPikalongDao.listPhuong(maQuanHuyen);
	}

}

package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.QuocTichPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.QuocTichPikalong;

@Service
public class QuocTichPikalongServiceImpl implements QuocTichPikalongService {
	
	@Autowired
	private QuocTichPikalongDao quocTichPikalongDao;
	
	public void setQuocTichPikalongDao(QuocTichPikalongDao quocTichPikalongDao) {
		this.quocTichPikalongDao = quocTichPikalongDao;
	}
	
	@Override
	@Transactional
	public List<QuocTichPikalong> listQuocTich() {
		
		return quocTichPikalongDao.listQuocTich();
	}

}

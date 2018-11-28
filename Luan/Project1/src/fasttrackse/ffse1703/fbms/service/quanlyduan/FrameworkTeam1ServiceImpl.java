package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.FrameworkTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.FrameworkTeam1;
@Service
public class FrameworkTeam1ServiceImpl implements FrameworkTeam1Service {
	@Autowired 
	FrameworkTeam1Dao framworkDao;

	@Override
	@Transactional
	public List<FrameworkTeam1> getAll() {
		return this.framworkDao.getAll();
	}

	@Override
	@Transactional
	public void delete(String ma_framework) {
		this.framworkDao.delete(ma_framework);
	}

	@Override
	@Transactional
	public void save(FrameworkTeam1 frameworkTeam1) {
		this.framworkDao.save(frameworkTeam1);
		
	}

	@Override
	@Transactional
	public FrameworkTeam1 getById(String ma_framework) {
		return this.framworkDao.getById(ma_framework);

	}

	@Override
	@Transactional
	public void update(FrameworkTeam1 frameworkTeam1) {
		this.framworkDao.update(frameworkTeam1);
		
	}
	@Transactional
	@Override
	public void setIsDelete(String ma_framework) {
		this.framworkDao.setIsDelete(ma_framework);
		
	}
	@Transactional
	@Override
	public int getName(String ten_framework) {
		return this.framworkDao.getName(ten_framework);
	}


}

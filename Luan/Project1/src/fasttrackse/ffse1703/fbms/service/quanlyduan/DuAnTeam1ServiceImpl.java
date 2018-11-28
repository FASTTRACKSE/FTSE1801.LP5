package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.DuAnTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;


@Service
public class DuAnTeam1ServiceImpl implements DuAnTeam1Service {

	@Autowired
	DuAnTeam1Dao duAnTeam1Dao;

	@Override
	@Transactional
	public void delete(String maDuAn) {
		this.duAnTeam1Dao.delete(maDuAn);

	}

	@Override
	@Transactional
	public void save(DuAnTeam1 duAn) {
		this.duAnTeam1Dao.save(duAn);

	}

	@Override
	@Transactional
	public DuAnTeam1 getById(String maDuAn) {
		return this.duAnTeam1Dao.getById(maDuAn);
	}

	@Override
	@Transactional
	public void update(DuAnTeam1 duAn) {
		this.duAnTeam1Dao.update(duAn);

	}

	@Override
	@Transactional
	public void setIsDelete(String maDuAn) {
		this.duAnTeam1Dao.setIsDelete(maDuAn);

	}

	@Override
	@Transactional
	public int getName(String tenDuAn) {
		return this.duAnTeam1Dao.getName(tenDuAn);
	}

	@Override
	@Transactional
	public List<DuAnTeam1> findAll(Integer offset, Integer maxResult,String search) {
		return this.duAnTeam1Dao.findAll(offset, maxResult,search);
		}

	@Override
	@Transactional
	public int count(String search) {
		return duAnTeam1Dao.count(search);
	}
	
	@Override
	@Transactional
	public List<DuAnTeam1>getAll() {
		return this.duAnTeam1Dao.getAll();
	}


	
}
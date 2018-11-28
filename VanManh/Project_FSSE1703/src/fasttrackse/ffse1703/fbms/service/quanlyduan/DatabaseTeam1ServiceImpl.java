package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.DatabaseTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DatabaseTeam1;

@Service
public class DatabaseTeam1ServiceImpl implements DatabaseTeam1Service {
	@Autowired
	DatabaseTeam1Dao databaseDao;

	@Override
	@Transactional
	public List<DatabaseTeam1> getAll() {
		return this.databaseDao.getAll();
	}

	@Override
	@Transactional
	public void delete(String maDatabase) {
		this.databaseDao.delete(maDatabase);

	}

	@Transactional
	@Override
	public void save(DatabaseTeam1 database) {
		this.databaseDao.save(database);

	}

	@Transactional
	@Override
	public DatabaseTeam1 getById(String maDatabase) {
		return this.databaseDao.getById(maDatabase);
	}

	@Transactional
	@Override
	public void update(DatabaseTeam1 database) {
		this.databaseDao.update(database);

	}

	@Transactional
	@Override
	public void setIsDelete(String maDatabase) {
		this.databaseDao.setIsDelete(maDatabase);

	}

	@Transactional
	@Override
	public int getName(String tenDatabase) {
		return this.databaseDao.getName(tenDatabase);
	}

}

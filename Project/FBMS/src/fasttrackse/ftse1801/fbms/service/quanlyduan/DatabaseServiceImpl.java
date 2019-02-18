package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.DatabaseDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.Database;
@Service
public class DatabaseServiceImpl implements DatabaseServices {
	@Autowired
	private DatabaseDao databaseDao;

	public void setDatabaseDAO(DatabaseDao databaseDao) {
		this.databaseDao = databaseDao;
	}

	@Override
	@Transactional
	public List<Database> findAll() {
		return databaseDao.findAll();
	}

	@Override
	@Transactional
	public Database findById(String maDatabase) {
		return databaseDao.findById(maDatabase);
	}

	@Override
	@Transactional
	public void addNew(Database database) {
		databaseDao.addNew(database);

	}

	@Override
	@Transactional
	public void update(Database database) {
		databaseDao.update(database);

	}

	@Override
	@Transactional
	public void delete(Database database) {
		databaseDao.delete(database);

	}

	@Override
	@Transactional
	public int checkNameDatabase(String tenDatabase) {
		return databaseDao.checkNameDatabase(tenDatabase);
	}

	@Override
	@Transactional
	public int checkMaDatabase(String maDatabase) {
		return databaseDao.checkMaDatabase(maDatabase);
	}

	@Override
	@Transactional
	public int countDatabase() {
		return databaseDao.countDatabase();
	}

	@Override
	@Transactional
	public List<Database> listDatabase(int start, int maxRows) {
		return databaseDao.listDatabase(start, maxRows);
	}

}

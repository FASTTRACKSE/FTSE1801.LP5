package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.DatabaseDAOs;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
@Service
public class DatabaseServiceImpls implements DatabaseServices{
	@Autowired
	private DatabaseDAOs databaseDAO;
	

	public void setDatabaseDAO(DatabaseDAOs databaseDAO) {
		this.databaseDAO = databaseDAO;
	}

	@Override
	@Transactional
	public List<Database> findAll() {
		return databaseDAO.findAll();
	}

	@Override
	@Transactional
	public Database findById(String id) {
		return databaseDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Database database) {
		databaseDAO.addNew(database);
	}

	@Override
	@Transactional
	public void update(Database Database) {
		databaseDAO.update(Database);
	}

	@Override
	@Transactional
	public void delete(Database database) {
		databaseDAO.delete(database);
	}
	@Override
	@Transactional
	public int checkNameDatabase(String nameDatabase) {
		
		return databaseDAO.checkNameDatabase(nameDatabase);
	}

	@Override
	@Transactional
	public int checkMaDatabase(String idDatabase) {
	
		return databaseDAO.checkMaDatabase(idDatabase);
	}

	@Override
	@Transactional
	public int countDatabase() {
		return databaseDAO.countDatabase();
	}

	@Override
	@Transactional
	public List<Database> listDatabase(int start, int maxRows) {
		
		return databaseDAO.listDatabase(start, maxRows);
	}
}

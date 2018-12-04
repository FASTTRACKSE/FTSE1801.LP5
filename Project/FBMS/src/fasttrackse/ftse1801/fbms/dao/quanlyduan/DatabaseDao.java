package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Database;

public interface DatabaseDao {
	public List<Database> findAll();
	public Database findById(String id);
	public void addNew(Database database);
	public void update(Database database);
	public void delete(Database database);
	public int checkNameDatabase(String nameDatabase);
	public int checkMaDatabase(String idDatabase);
	public int countDatabase();
	public List<Database> listDatabase(int start, int maxRows);
}

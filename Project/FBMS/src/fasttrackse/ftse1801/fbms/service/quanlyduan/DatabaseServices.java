package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Database;

public interface DatabaseServices {
	public List<Database> findAll();

	public Database findById(String maDatabase);

	public void addNew(Database database);

	public void update(Database database);

	public void delete(Database database);

	public int checkNameDatabase(String tenDatabase);

	public int checkMaDatabase(String maDatabase);
	
	public int countDatabase();
	
	public List<Database> listDatabase(int start, int maxRows);
}

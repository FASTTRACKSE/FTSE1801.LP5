package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;

public interface DatabaseServices {
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

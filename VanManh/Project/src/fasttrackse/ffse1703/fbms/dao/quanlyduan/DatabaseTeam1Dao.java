package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DatabaseTeam1;

public interface DatabaseTeam1Dao {
	public List<DatabaseTeam1> getAll();
	public void delete(String maDatabase);
	public void save(DatabaseTeam1 database);
	public DatabaseTeam1 getById(String maDatabase);
	public void update(DatabaseTeam1 database);
	public void setIsDelete(String maDatabase);
	public int getName(String tenDatabase);
	


}

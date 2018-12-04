package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Framework;

public interface FrameworkDao {
	public List<Framework> getAll();
	public Framework getById(String maFramework);
	public void add(Framework framework);
	public void update(Framework framework);
	public void delete(String maFramework);
	public int checkNameFramework(String tenFramework);
	public List<Framework> listFramework(int start, int maxRows);
	public int countFramework();
}

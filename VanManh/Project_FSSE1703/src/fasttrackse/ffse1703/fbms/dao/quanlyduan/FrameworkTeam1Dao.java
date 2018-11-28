package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.FrameworkTeam1;

public interface FrameworkTeam1Dao {
	public List<FrameworkTeam1> getAll();
	public void delete(String ma_framework);
	public void save(FrameworkTeam1 frameworkTeam1);
	public FrameworkTeam1 getById(String ma_framework);
	public void update(FrameworkTeam1 frameworkTeam1);
	public void setIsDelete(String ma_framework);
	public int getName(String ten_framework);

}

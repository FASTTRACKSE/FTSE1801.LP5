package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;

public interface StatusDAO {
	public List<StatusProject> findAll();
	public StatusProject findById(int id);
	public void addNew(StatusProject status);
	public void update(StatusProject status);
	public void delete(StatusProject status);
	public int checkNameStatus(String nameStatus);
	public List<StatusProject> listStatusProject(int start, int maxRows);
	public int countStatusProject() ;
}

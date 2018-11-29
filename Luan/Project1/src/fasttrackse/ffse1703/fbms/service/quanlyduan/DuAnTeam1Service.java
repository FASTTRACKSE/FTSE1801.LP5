package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;


public interface DuAnTeam1Service {
	public List<DuAnTeam1> getAll();

	public void delete(String maDuAn);

	public void save(DuAnTeam1 duAn);

	public DuAnTeam1 getById(String maDuAn);

	public void update(DuAnTeam1 duAn);

	public void setIsDelete(String maDuAn);

	public int getName(String tenDuAn);

	public List<DuAnTeam1> findAll(Integer offset, Integer maxResult, String search);

	public int count(String search);

}
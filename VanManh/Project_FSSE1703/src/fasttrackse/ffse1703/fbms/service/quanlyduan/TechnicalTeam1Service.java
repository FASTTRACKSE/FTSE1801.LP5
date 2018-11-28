package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.TechnicalTeam1;

public interface TechnicalTeam1Service {
	public List<TechnicalTeam1> getAll();
	public void delete(String maCongNghe);
	public void save(TechnicalTeam1 congNghe);
	public TechnicalTeam1 getById(String maCongNghe);
	public void update(TechnicalTeam1 congNghe);
	public void setIsDelete(String maCongNghe);
	public int getName(String tenCongNghe);
}

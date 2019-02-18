package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.CongNghe;

public interface CongNgheService {
	public List<CongNghe> findAll();
	public CongNghe findById(String maCongNghe);
	public void addNew(CongNghe congNghe);
	public void update(CongNghe congNghe);
	public void delete(CongNghe congNghe);
	public int checkNameCongNghe(String tenCongNghe);
	public int checkMaCongNghe(String maCongNghe);
	public List<CongNghe> listCongNghe(int start, int maxRows);
	public int countCongNghe();
}

package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NgonNgu;

public interface NgonNguDao {

	public List<NgonNgu> getAll();
	public NgonNgu getById(String maNgonNgu);
	public void add(NgonNgu ngonNgu);
	public void update(NgonNgu ngonNgu);
	public void delete(String maNgonNgu);
	public int checkNameLanguage(String tenNgonNgu);
	public List<NgonNgu> listNgonNgu(int start, int maxRows);
	public int countNgonNgu();
	public int checkMa(String maNgonNgu);
}

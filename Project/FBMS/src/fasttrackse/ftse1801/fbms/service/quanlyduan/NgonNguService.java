package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NgonNgu;

public interface NgonNguService {
	public List<NgonNgu> getAll();
	public NgonNgu getById(String maNgonNgu);
	public void add(NgonNgu ngonNgu);
	public void update(NgonNgu ngonNgu);
	public void delete(String maNgonNgu);
	public int checkName(String tenNgonNgu);
	public List<NgonNgu> listNgonNgu(int start, int maxRows);
	public int countLanguage();
	public int checkMa(String maNgonNgu);
}

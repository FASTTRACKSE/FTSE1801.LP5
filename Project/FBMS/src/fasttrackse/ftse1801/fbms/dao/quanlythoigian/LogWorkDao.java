package fasttrackse.ftse1801.fbms.dao.quanlythoigian;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlythoigian.LogWork;


public interface LogWorkDao {
	public void addLogWork(LogWork logWork);
	public void editTrangThai(LogWork logWork);
	public void editLogWork(LogWork logWork);
	public void deleteLogWork(LogWork logWork);
	public List<LogWork> getAllLorkWork();
	public LogWork getLorkWorkTheoNhanVien(int maNV);
	public List<LogWork> getNhapTheoNhanVien(int maNV);
	public List<LogWork> getAllChoPheDuyet();
	public List<LogWork> getAllPheDuyetLan1();
	public List<LogWork> getAllDapheDuyet();
	public List<LogWork> getChoPheDuyetTheoNhanVien(int maNV);
	public List<LogWork> getAllPheDuyetLan1TheoNhanVien(int maNV);
	public List<LogWork> getAllDapheDuyetTheoNhanVien(int maNV);
	public List<LogWork> getAllBiTuChoiTheoNhanVien(int maNV);
	public List<LogWork> getAllBiTuChoi();
	public List<LogWork> getAllLogWorkTheoThang(int thang,int nam);
	public List<LogWork> getLogWorkTheoThangTheoNhanVien(int thang,int nam, int maNV);
}
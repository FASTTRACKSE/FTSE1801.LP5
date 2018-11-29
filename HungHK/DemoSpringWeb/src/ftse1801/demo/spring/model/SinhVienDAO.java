package ftse1801.demo.spring.model;

import java.util.List;

import ftse1801.demo.spring.model.entity.SinhVien;

public interface SinhVienDAO {
	
	public List<SinhVien> getAllSinhVien(int trang, int soDong);
	
	public List<SinhVien> getAllSinhVien1();
	
	public void addSinhVien(SinhVien sinhVien);
	
	public void updateSinhVienByMasv(SinhVien  sinhVien);
	
	public void deleteSinhVienByMasv(String  maSv);
	
	public SinhVien getSinhVienByMasv(String maSv);
	
	public int getCount(int soDong);
}

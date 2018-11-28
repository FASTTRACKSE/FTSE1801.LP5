package sinhvien.model.dao;

import java.util.ArrayList;

import sinhvien.model.entity.SinhVien;

public interface ISinhVienDAO {	
	public ArrayList<SinhVien> getAllSinhVien();
	
	public boolean deleteSinhVien(String id);
	
	public boolean addNewSinhVien(SinhVien sinhvien);
	
	public boolean updateSinhVien(SinhVien sinhvien,String id);
	
	public SinhVien getSinhVien(String id);
	
	public ArrayList<SinhVien> getAll(int trang,int soDong);
	
	public int getCount(int soDong);
}

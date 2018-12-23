package ftse1801.demo.spring.dao;

import java.util.ArrayList;

import ftse1801.demo.spring.entity.SinhVien;


public interface ISinhVienDao {	 
	
	/*
	 * Hiển thị
	 */
	public ArrayList<SinhVien> getAllSinhVien();
	
	
	
	public ArrayList<SinhVien> getAllSinhVien1(int paging, int soDong);
	public int getCount(int soDong);
	public ArrayList<SinhVien> getSinhVien();
	/* Xóa sinh viên */

	public boolean DeleteSinhVien(int id);

	/* Sửa thông tin sinh viên */
	public boolean UpdateSinhVien(SinhVien sinhvien, int id);
	/* Thêm thành viên */

	public boolean addSinhVien(String ten, String tuoi, String diachi, String lop, String img);
	
	public SinhVien getAllSvById(int id);
	public ArrayList<SinhVien> getSinhVien1();
	
}

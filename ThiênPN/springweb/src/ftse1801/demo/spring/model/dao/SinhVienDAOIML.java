package ftse1801.demo.spring.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ftse1801.demo.spring.model.entity.Diem;
import ftse1801.demo.spring.model.entity.SinhVien;

public interface SinhVienDAOIML {
	
	/**
	 * thêm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean addSinhVien(String maSV, String tenSV, String pass, String tuoi);

	/**
	 * thêm điểm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean addDiemSV(String maSV, String monHoc, int diem);

	/**
	 * UpDate Sinh viên theo mã sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean updateSV(String maSV, String ten, String pass);

	/**
	 * Delete Điểm sinh viên theo mã và môn học
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean deleteDiemSV(SinhVien sinhVien);

	/**
	 * Delete Sinh viên theo mã sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean deleteSV(String maSinhVien);

	/**
	 * Update điểm sinh viên theo mã và môn học
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean UpdateDiemSV(String maSV, String MH, int diem);

	/**
	 * Hiển thị danh sách sinh viên
	 * 
	 * @return
	 */

	public ArrayList<SinhVien> getAllSinhVien(int trang, int soDong);

	/**
	 * hiển thị danh sách sinh viên theo tên
	 * 
	 * @param ten
	 * @return
	 */
	public ArrayList<SinhVien> getSinhVienTheoTen(SinhVien sinhVien);

	public SinhVien SinhVienByMa(String maSV);
	public int getCount(int soDong);
}

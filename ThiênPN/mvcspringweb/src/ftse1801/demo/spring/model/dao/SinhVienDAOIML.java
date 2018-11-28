package ftse1801.demo.spring.model.dao;


import java.util.ArrayList;
import java.util.List;

import ftse1801.demo.spring.model.entity.Diem;
import ftse1801.demo.spring.model.entity.SinhVien;

public interface SinhVienDAOIML {
	
	/**
	 * thêm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean addSinhVien(String maSV, String tenSV, String pass, String tuoi,String image,List<Diem>diem);

	/**
	 * thêm điểm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean addDiemSV(String maSV,String monHoc, int diem);

	/**
	 * UpDate Sinh viên theo mã sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */

	public boolean updateSV(String maSV, String ten, String pass,String tuoi,List<Diem>diem);

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
	public ArrayList<SinhVien> getAllSinhVien1();

	/**
	 * hiển thị danh sách sinh viên theo tên
	 * 
	 * @param ten
	 * @return
	 */
	public ArrayList<SinhVien> getSinhVienTheoTen(SinhVien sinhVien);

	public SinhVien SinhVienByMa(String maSV);
	public int getCount(int soDong);
	public boolean addAllSinhVien(SinhVien sinhvien);
}

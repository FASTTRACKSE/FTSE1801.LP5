package ftse1801.demo.spring.model;

import java.util.ArrayList;

import ftse1801.demo.spring.model.entity.SinhVien;


public interface IQLSinhVienDAO {

	public ArrayList<SinhVien> displayAllSinhVien(int page , int size);
	
	
	public boolean deleteSinhVienByMaSV(String  id);
	
	public boolean addSinhVien(String image ,String id, String name, int age);
	
	public boolean updateSinhVienByMaSV(String name, int age, String id, String image);
	
	
	public int soTrang(int soDong) ;
	
	public SinhVien displaySinhVientheoMa(String id);
	
//	public Map<String,String> englishlanguage(){
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("masv", "Id");
//		map.put("ten", "Name");
//		map.put("tuoi", "Age");
//		map.put("chucnang", "Function");
//		map.put("them", "Add");
//		map.put("sua", "Update");
//		map.put("xoa", "Delete");
//		map.put("ngonngu", "Selection Laguage");
//		map.put("vietnam", "VietNamese");
//		map.put("english", "English");
//		map.put("themthongtin", "Add information");
//		return map;
//	}
//	
//	public Map<String,String> vietnamlaguage(){
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("masv", "Mã sinh viên");
//		map.put("ten", "Tên sinh viên");
//		map.put("tuoi", "Tuổi sinh viên");
//		map.put("chucnang", "Chức năng");
//		map.put("them", "Thêm");
//		map.put("sua", "Sửa");
//		map.put("xoa", "Xóa");
//		map.put("ngonngu", "Chọn ngôn ngữ");
//		map.put("vietnam", "Việt Nam");
//		map.put("english", "Tiếng Anh");
//		map.put("themthongtin", "Thêm thông tin sinh viên");
//		return map;
//	}
	
	public boolean login(String name, String pass);
	
	public SinhVien displaySV(String name);
	
	public ArrayList<SinhVien> displayAllSinhVien();
	
}

package model.dao;

import java.util.HashMap;
import java.util.Map;

public class NgonNguDao {
public Map<String, String> englishLanguage(){
	Map<String, String> map= new HashMap<>();
	map.put("TieuDe", "My Login form");
	map.put("TenDangNhap", "Username");
	map.put("Tuoi", "Old");
	map.put("DiaChi", "Adress");
	map.put("Sdt", "NumberPhone");
	map.put("Them", "Add");
	map.put("Sua", "Edit");
	map.put("Xoa", "Delete");
	map.put("TieuDe1", "List Student");
	map.put("ChucNang", "Fution");
	map.put("id", "Id");
	map.put("title", "Student Manager");
	
	return map;	
}
public Map<String, String> vietnameseLanguage(){
	Map<String, String> map= new HashMap<>();
	map.put("TieuDe", "Nhập thông tin");
	map.put("TenDangNhap", "Tên sinh viên");
	map.put("Tuoi", "Tuổi");
	map.put("DiaChi", "Địa chỉ");
	map.put("Sdt", "Số điện thoại");
	map.put("Them", "Thêm");
	map.put("Sua", "Sửa");
	map.put("Xoa", "Xóa");
	map.put("TieuDe1", "Danh sách sinh viên");
	map.put("ChucNang", "Chức năng");
	map.put("id", "Mã sinh viên");
	map.put("title", "Quản lý sinh viên");
	
	return map;	
}
}

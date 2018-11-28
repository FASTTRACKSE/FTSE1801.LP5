package model.dao;

import java.util.HashMap;
import java.util.Map;

public class LanguageDao {
	public Map<String, String> english(){
		Map<String, String> map =  new HashMap<>();
		map.put("themSV", "Add Students");
		map.put("maSV", "ID");
		map.put("tenSV", "Name");
		map.put("monHoc", "Subject");
		map.put("diem", "Point");
		map.put("sua", "Edit");
		map.put("xoa", "Delete");
		map.put("lui", "Back");
		map.put("tien", "Next");
		map.put("dau", "Begin");
		map.put("cuoi", "Final");
		
		return map;
		
	}
	
	public Map<String, String> vietnamese(){
		Map<String, String> map =  new HashMap<>();
		map.put("themSV", "Thêm Sinh Viên");
		map.put("maSV", "Mã sinh viên");
		map.put("tenSV", "Tên sinh viên");
		map.put("monHoc", "Môn học");
		map.put("diem", "Điểm");
		map.put("sua", "Sửa");
		map.put("xoa", "Xóa");
		map.put("lui", "Lùi");
		map.put("tien", "Tiến");
		map.put("dau", "Đầu");
		map.put("cuoi", "Cuối");
		
		return map;
		
	}
}

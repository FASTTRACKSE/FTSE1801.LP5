package model.dao;

import java.util.HashMap;
import java.util.Map;

public class NgonNguDao {
	public Map<String, String> EnglishLaguage(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "ID");
		map.put("ten", "Name");
		map.put("tuoi", "age");
		map.put("diachi", "address");
		map.put("lop", "class");
		map.put("chucnang", "Function");
		map.put("them", "add");
		map.put("sua", "edit");
		map.put("xoa", "delete");
		return map;
	}
	public Map<String, String> VietNameseLaguage() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "Mã sinh viên");
		map.put("ten", "Tên sinh viên");
		map.put("tuoi", "Tuổi");
		map.put("diachi", "Địa chỉ");
		map.put("lop", "Lớp");
		map.put("chucnang", "Chức năng");
		map.put("them", "Thêm");
		map.put("sua", "Sửa");
		map.put("xoa", "Xóa");

		return map;

	}
	public Map<String, String> TrungQuocLaguage() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "学生代码");
		map.put("ten", "学生姓名");
		map.put("tuoi", "年龄");
		map.put("diachi", "地址");
		map.put("lop", "类");
		map.put("chucnang", "功能");
		map.put("them", "更");
		map.put("sua", "修复");
		map.put("xoa", "抹去");

		return map;

	}

}

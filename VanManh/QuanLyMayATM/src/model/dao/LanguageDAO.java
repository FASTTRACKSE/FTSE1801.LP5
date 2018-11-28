package model.dao;

import java.util.HashMap;
import java.util.Map;

public class LanguageDAO {
	public Map<String, String> vietNamese() {
		Map<String, String> map = new HashMap<>();
			map.put("maKH", "Ma Khach Hang");
			map.put("ten", "Ten khach hang");
			map.put("diaChi", "Dia chi");
			map.put("phuong", "Phuong");
			map.put("quan", "Quan");
			map.put("sdt", "So dien thoai");
			map.put("soThe", "So the ATM");
			map.put("soTien", "So tien");
			map.put("them", "Them");
			map.put("sua", "Sua");
			map.put("xoa", "Xoa");
		return map;
	}
	
	public Map<String, String> english() {
		Map<String, String> map = new HashMap<>();
			map.put("maKH", "Customer's code");
			map.put("ten", "Name");
			map.put("diaChi", "Address");
			map.put("phuong", "Ward");
			map.put("quan", "County");
			map.put("sdt", "Phone number");
			map.put("soThe", "ATM card number");
			map.put("soTien", "Amount of money");
			map.put("them", "Add");
			map.put("sua", "Edit");
			map.put("xoa", "Delete");
		return map;
	}
}

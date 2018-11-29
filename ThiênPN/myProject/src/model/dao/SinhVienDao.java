package model.dao;

import java.util.ArrayList;

import model.entity.SinhVien;

public class SinhVienDao {
   public ArrayList<SinhVien> getSinhVien() {
	   SinhVien sinhVien;
	   ArrayList<SinhVien> list = new ArrayList<SinhVien>();
	   sinhVien = new SinhVien("hiệu", "1801011", "21", "Quảng Nam");
	   list.add(sinhVien);
	   sinhVien = new SinhVien("hưng", "1801012", "30", "Đà Nẵng");
	   list.add(sinhVien);
	   sinhVien = new SinhVien("Sơn", "1801013", "24", "Đà Nẵng");
	   list.add(sinhVien);
	   
	   return list;
	   
   }
}

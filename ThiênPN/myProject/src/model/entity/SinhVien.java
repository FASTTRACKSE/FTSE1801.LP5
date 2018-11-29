package model.entity;

public class SinhVien {
  private String ten;
  private String lop;
  private String tuoi;
  private String diaChi;
  
public SinhVien(String ten, String lop, String tuoi, String diaChi) {
	super();
	this.ten = ten;
	this.lop = lop;
	this.tuoi = tuoi;
	this.diaChi = diaChi;
}
public SinhVien() {
	
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getLop() {
	return lop;
}
public void setLop(String lop) {
	this.lop = lop;
}
public String getTuoi() {
	return tuoi;
}
public void setTuoi(String tuoi) {
	this.tuoi = tuoi;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
  
}

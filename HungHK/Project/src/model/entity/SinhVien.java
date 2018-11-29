package model.entity;

public class SinhVien {
	private String ten;
	private String tuoi;
	private String lop;
	private String diaChi;
	public SinhVien(String ten, String tuoi, String lop, String diaChi) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.lop = lop;
		this.diaChi = diaChi;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}

package id.impl;

public class SinhVien {
	private String id;
	private String ten;
	private String tuoi;
	private String diachi;
	private String lop;

	public SinhVien() {

	}

	public SinhVien(String id, String ten, String tuoi, String diachi, String lop) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.lop = lop;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

}

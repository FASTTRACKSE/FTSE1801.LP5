package model.entity;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */

public class SinhVien {
	private String maSinhVien;
	private String tensinhVien;
	private String password;
	private String tuoi;
	private Diem diem;

	public SinhVien(String maSinhVien, String tensinhVien, String password,String tuoi, Diem diem) {
		super();
		this.maSinhVien = maSinhVien;
		this.tensinhVien = tensinhVien;
		this.password = password;
		this.tuoi = tuoi;
		this.diem = diem;
	}

	public SinhVien() {

	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTensinhVien() {
		return tensinhVien;
	}

	public void setTensinhVien(String tensinhVien) {
		this.tensinhVien = tensinhVien;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

}

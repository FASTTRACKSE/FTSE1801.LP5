package model.entity;

abstract public class SinhVienFpt {
	public String hoTen;
	public String nganh;
	
	public SinhVienFpt(String hoTen, String nganh) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	
	abstract public double getDiem();
	
	public String getHocLuc() {
		if(getDiem()<5) {
			return "Yếu";
		}
		else if(getDiem()<6.5) {
			return "Trung bình";
		}
		else if(getDiem()<7.5) {
			return "Khá";
		}
		else if(getDiem()<9) {
			return "Giỏi";
		}
		else {
			return "Xuất sắc";
		}
	}
	
	public void xuat() {
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Ngành: " + getNganh());
		System.out.println("Điểm: " + getDiem());
		System.out.println("Học lực: " + getHocLuc() + "\n");
	}
}

package sinhvien;

abstract class SinhVienFpt{
	private String hoTen;
	private String nganh;
	public SinhVienFpt() {
		// TODO Auto-generated constructor stub
	}
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
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	
	String getTen() {
		return hoTen;
	}
	
	abstract double getDiem();
	
	String getHocLuc() {
		if(getDiem() >8) {
			return "Giỏi";
		}else if(getDiem() > 7){
			return "Khá";
		}else {
			return "TB";
		}
		
	}
	String getNganh() {
		return nganh;
	}
	
	public void xuat() {
		System.out.println("ho ten: " + hoTen);
		System.out.println("nganh: " + nganh);
		System.out.println("Diem: " + getDiem());
		System.out.println("Hoc luc: " + getHocLuc());
	}

}

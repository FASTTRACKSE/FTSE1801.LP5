package demoSV;

public abstract class SinhVienFPT {
	private String ten;
	private String nganh;
	abstract double getDiemTB();
	
		
	public SinhVienFPT(String ten, String nganh) {
		super();
		this.ten = ten;
		this.nganh = nganh;
	}


	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public String getHocLuc() {
		if(getDiemTB() <5) {
			return "Yếu";
		}else if(getDiemTB() < 7) {
			return "TB";
		}else if(getDiemTB() < 9){
			return "Khá";
		}else {
			return "Giỏi";
		}
	}
	public void xuat() {
		System.out.println(getTen() + "  " + getNganh() + "  " + getDiemTB() + "  " + getHocLuc());
	}
}

package di;

public abstract class SinhVienFPT {
	private String name;
	private String nganh;
	
	public SinhVienFPT() {
	}
	public SinhVienFPT(String name, String nganh) {
		this.name = name;
		this.nganh = nganh;
	}
	
	public abstract double getDiem();
	public String getHocLuc() {
		if (getDiem()<5) {
			return "yeu";
		}else if (getDiem()<6.5) {
			return "trung binh";
		}else if (getDiem()<8) {
			return "kha";
		}else {
			return"gioi";
		}
	};
	public void xuat() {
		System.out.println("Sinh vien " + name + " nganh " + nganh + " co diem la: "+ getDiem()+" ,hoc luc: " + getHocLuc());
	};
	
}

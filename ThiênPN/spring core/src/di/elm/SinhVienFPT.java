package di.elm;

public abstract class SinhVienFPT {
	private String hoTen;
	private String nghanh;

	public SinhVienFPT(String hoTen, String nghanh) {
		this.hoTen = hoTen;
		this.nghanh = nghanh;
	}
   
	abstract double getDiem();

	String getHocLuc() {
		if (getDiem() < 5) {
			return "yếu";
		} else if (getDiem() < 6.5) {
			return "trung bình";
		} else if (getDiem() < 7.5) {
			return "Khá";
		} else if (getDiem() < 9) {
			return "Giỏi";
		} else {
			return "Xuất Sắc";
		}
	}
	public void xuat() {
		System.out.println("Họ Tên SV: " + hoTen);
		System.out.println("Ngành SV: " + nghanh);
		
	}
}

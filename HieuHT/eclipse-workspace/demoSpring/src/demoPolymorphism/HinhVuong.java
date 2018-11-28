package demoPolymorphism;

public class HinhVuong extends HinhChuNhat{
	public HinhVuong(double canh) {
		super(canh, canh);
	}
	public void xuat() {
		System.out.println("Đây là hình vuông");
		System.out.println("Chu vi: " + getChuVi());
		System.out.println("Diện tích: " + getDienTich());
	}
}

package model.entity;

public class HinhVuong extends HinhChuNhat {
	public HinhVuong(double canh) {
		super(canh, canh);
	}
	
	public void xuat() {
		System.out.println("Chu vi hình vuông là: " + chuVi());
		System.out.println("Diện tích hình vuông là: " + dienTich());
	}
}

package id.impl;

public class HinhVuongAb extends HinhChuNhat {

	public HinhVuongAb(double canh) {
		super(canh, canh);
	}
	
	@Override
	public void xuat() {
		System.out.println("Day la hinh vuong");
		System.out.println("Chu vi: "+getChuVi());
		System.out.println("Dien tich "+getDienTich());
	}
}

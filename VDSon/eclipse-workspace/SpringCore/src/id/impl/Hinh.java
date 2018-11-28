package id.impl;

public abstract class Hinh {
	abstract double getChuVi();
	abstract double getDienTich();
	
	public void xuat() {
		System.out.println("Chu vi "+getChuVi());
		System.out.println("Dien tich "+getDienTich());
	}
}

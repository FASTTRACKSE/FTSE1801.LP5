package model.entity;

abstract class Hinh {
	abstract double chuVi();
	abstract double dienTich();
	
	public void xuat() {
		System.out.println("Chu vi: " + chuVi());
		System.out.println("Diện tích: " + dienTich());
	}
}

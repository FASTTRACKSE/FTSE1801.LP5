package di.impl;

abstract public class Hinh {
	abstract  double getChuVi();
	abstract  double getDienTich();
	public void xuat() {
		System.out.println("Chu vi:" + getChuVi());
		System.out.println("Diện tích:" + getDienTich());
	}
}

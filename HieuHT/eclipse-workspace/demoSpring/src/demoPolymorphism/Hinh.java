package demoPolymorphism;

public abstract class Hinh {
	abstract double getChuVi();
	abstract double getDienTich();
	
	public void xuat() {
		System.out.println("Chu Vi: " + getChuVi());
		System.out.println("Diện Tích: " + getDienTich());
	}
}

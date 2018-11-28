package Demo123;

abstract class Hinh {
	abstract double getChuVi();
	abstract double getDienTich();
	public void show() {
		System.out.println("Chu vi la :" + getChuVi());
		System.out.println("Dien tich la :" + getDienTich());
	}
}

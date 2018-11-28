package bean;

abstract class AllHinh {
	abstract double chuVi();
	abstract double dienTich();
	public void xuat() {
		System.out.println("Chu vi: "+chuVi());
		System.out.println("Dien tich: "+dienTich());
	}
}

package sinhvien;

abstract class Students {
	abstract String getTen();
	abstract double getDiem();
	abstract String getHocLuc();
	abstract String getNganh();
	
	public void xuat() {
		System.out.println("Diem: " + getDiem());
		System.out.println("Hoc luc: " + getHocLuc());
	}
	
	
}

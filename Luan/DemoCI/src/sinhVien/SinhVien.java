package sinhVien;

abstract class SinhVien {
	abstract String getTen();

	abstract String getNganh();

	abstract double getDiem();

	abstract String getHocLuc();

	public void xuat() {
		System.out.println("Họ tên: " + getTen());
		System.out.println("Ngành: " + getNganh());
		System.out.println("Điểm trung bình: " + getDiem());
		System.out.println("Học lực: " + getHocLuc());
		System.out.println("----------------------------");
	}
}

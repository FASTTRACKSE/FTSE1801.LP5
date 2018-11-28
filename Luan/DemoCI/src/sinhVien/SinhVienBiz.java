package sinhVien;

public class SinhVienBiz extends SinhVienFPT{
	private double diemMarketing;
	private double diemSales;
	
	public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	@Override
	double getDiem() {
		return (2*diemMarketing+diemSales)/3;
	}
	@Override
	public void xuat() {
		System.out.println("Đây là sinh viên Biz");
		super.xuat();
	}
}

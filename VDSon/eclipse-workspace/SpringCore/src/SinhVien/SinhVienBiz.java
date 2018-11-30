package SinhVien;

public class SinhVienBiz extends SinhVienFPT {

	double diemMarketing;
	double diemSales;

	public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	@Override
	double getDiem() {

		return (diemMarketing + diemSales) / 2;
	}
	@Override
	public void xuat() {
		System.out.println("Sinh Vien Biz");
		super.xuat();
	}

}

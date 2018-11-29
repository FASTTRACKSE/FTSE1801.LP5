package demoSV;

public class SinhVienBiz extends SinhVienFPT {
	private double diemMarketing;
	private double diemSales;
	public SinhVienBiz(String ten, String nganh, double diemMarketing, double diemSales) {
		super(ten, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	public double getDiemTB() {
		return (diemMarketing + diemSales)/3;
	}


	public void xuat() {
		System.out.println("Đây là sinh viên biz: ");
		super.xuat();
	}

}

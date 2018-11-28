package sinhVien;

public class SinhVienIT extends SinhVienFPT{
	private double diemJava;
	private double diemCss;
	private double diemHtml;
	public SinhVienIT(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}
	@Override
	double getDiem() {
		return (2*diemJava+diemCss+diemHtml)/4;
	}
	@Override
	public void xuat() {
		System.out.println("Đây là sinh viên IT");
		super.xuat();
	}
}

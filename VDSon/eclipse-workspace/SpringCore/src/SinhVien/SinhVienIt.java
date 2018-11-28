package SinhVien;

public class SinhVienIt extends SinhVienFPT {
	double diemJava;
	double diemCss;
	double diemHtml;

	public SinhVienIt(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}

	@Override
	double getDiem() {
		return (diemJava + diemCss + diemHtml)/3;
	}
	
	@Override
	public void xuat() {
		System.out.println("Sinh Vien IT");
		super.xuat();
	}
}

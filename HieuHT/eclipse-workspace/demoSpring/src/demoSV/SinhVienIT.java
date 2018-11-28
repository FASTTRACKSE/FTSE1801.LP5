package demoSV;

public class SinhVienIT extends SinhVienFPT {
	private double diemJava;
	private double diemCss;
	private double diemHtml;
	
	public SinhVienIT(String ten, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(ten, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}


	public double getDiemTB() {
		return (diemJava + diemCss + diemHtml)/3;
	}
	public void xuat() {
		System.out.println("Đây là sinh viên IT: ");
		super.xuat();
	}
}

package model.entity;

public class SinhVienIT extends SinhVienFpt {
	private double diemHtml;
	private double diemCss;
	private double diemJava;
	
	public double getDiemHtml() {
		return diemHtml;
	}
	public void setDiemHtml(double diemHtml) {
		this.diemHtml = diemHtml;
	}
	public double getDiemCss() {
		return diemCss;
	}
	public void setDiemCss(double diemCss) {
		this.diemCss = diemCss;
	}
	public double getDiemJava() {
		return diemJava;
	}
	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}

	public SinhVienIT(String hoTen, String nganh, double diemHtml, double diemCss, double diemJava) {
		super(hoTen, nganh);
		this.diemHtml = diemHtml;
		this.diemCss = diemCss;
		this.diemJava = diemJava;
	}

	@Override
	public double getDiem() {
		return (diemJava*2 + diemHtml + diemCss)/4;
	}
	
}

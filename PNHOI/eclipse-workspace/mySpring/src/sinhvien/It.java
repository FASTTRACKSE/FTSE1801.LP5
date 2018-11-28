package sinhvien;

public class It extends SinhVienFpt{
	private double java;
	private double css;
	private double html;
	
	public It() {
	}
	
	public It(String hoTen, String nganh, double java, double css, double html) {
		super(hoTen, nganh);
		this.java = java;
		this.css = css;
		this.html = html;
	}
	public double getJava() {
		return java;
	}
	public void setJava(double java) {
		this.java = java;
	}
	public double getCss() {
		return css;
	}
	public void setCss(double css) {
		this.css = css;
	}
	public double getHtml() {
		return html;
	}
	public void setHtml(double html) {
		this.html= html;
	}
	@Override
	public double getDiem() {
		return (java + css + html)/3;
	}
	@Override
	public void xuat() {
		System.out.println("Day la sinh vien it");
		super.xuat();
	}
	
}

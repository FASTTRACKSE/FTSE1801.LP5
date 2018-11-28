package di.impl;

import di.SinhVienFPT;

public class SinhVienIT extends SinhVienFPT {
	private double diemJava;
	private double diemCss;
	private double diemHtml;

	public SinhVienIT() {
	}

	public SinhVienIT(double diemJava, double diemCss, double diemHtml, String name) {
		super(name, "IT");
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}
	
	@Override
	public double getDiem() {
		return (diemCss+diemJava+diemHtml)/3;
	}
}

package di.impl;

import di.SinhVienFPT;

public class SinhVienBiz extends SinhVienFPT{
	private double diemMarketing;
	private double diemSales;

	public SinhVienBiz() {
	}
	
	public SinhVienBiz(double diemMarketing, double diemSales,String name) {
		super(name,"Biz");
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	@Override
	public double getDiem() {
		return (diemMarketing*2+diemSales)/3;
	}
}

package id.impl;

public class HinhChuNhat extends Hinh {
	private double dai;
	private double rong;

	public HinhChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}

	@Override
	double getChuVi() {
		return (dai + rong) * 2;
	}

	@Override
	double getDienTich() {
		return dai * rong;
	}
	@Override
	public void xuat() {
		System.out.println("Hinh chu nhat");
		super.xuat();
	}
}

package di.impl;

import di1.Hinh;

public class ChuNhat extends di.impl.Hinh {
	private double dai;
	private double rong;
	public ChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	
	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}

	public double getChuVi() {
		return (dai +rong) *2;
		
	}
	public double getDienTich() {
		return dai*rong;
	}
	public void xuat() {
		
		System.out.println("- Chiều dài hinh hcn:" + dai);
		System.out.println("- Chiều rộng hinh hcn:" + rong);
		System.out.println("- Dien tích hinh hcn:" + getDienTich());
		System.out.println("- Chu vi hinh hcn:" + getChuVi());
		
	}
	
}

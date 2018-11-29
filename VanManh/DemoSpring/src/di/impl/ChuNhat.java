package di.impl;

import di.Hinh;

public class ChuNhat implements Hinh{
	private double cd;
	private double cr;
	
	public ChuNhat() {
	}
	
	public ChuNhat(double cd, double cr) {
		this.cd = cd;
		this.cr = cr;
	}

	@Override
	public double chuVi() {
		return (cd + cr)*2;
	}

	@Override
	public double dienTich() {
		return cd*cr;
	}
	
}

package id.impl;

import di.Hinh;

public class ChuNhat implements Hinh {

	@Override
	public double chuvi(double dai, double rong) {
		return (dai + rong) * 2;
	}

	@Override
	public double dientich(double dai, double rong) {
		return dai * rong;
	}
}

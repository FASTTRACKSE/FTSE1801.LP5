package id.impl;

import di.Hinh;

public class HinhVuongClient extends ChuNhatClient {
	@Override
	public void setHinhClient(Hinh hinh) {
		super.setHinhClient(hinh);
	}
	public void xuat() {
		System.out.println("Hinh Vuong");
		System.out.println("Chu vi:" +hinh.chuvi(4, 4));
		System.out.println("Dien tich " +hinh.dientich(4, 4));
	}
}

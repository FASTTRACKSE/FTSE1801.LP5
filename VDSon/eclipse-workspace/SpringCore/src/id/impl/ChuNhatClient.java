package id.impl;

import di.Hinh;
import di.HinhClient;

public class ChuNhatClient implements HinhClient {
	Hinh hinh;

	@Override
	public void setHinhClient(Hinh hinh) {
		this.hinh = hinh;
	}

	@Override
	public void xuat() {
		System.out.println("Chu vi  " + hinh.chuvi(5, 6));
		System.out.println("Diện tích " + hinh.dientich(5, 6));
	}

}

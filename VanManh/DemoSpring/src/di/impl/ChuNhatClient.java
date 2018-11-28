package di.impl;

import di.Hinh;
import di.HinhClient;

public class ChuNhatClient implements HinhClient{
	Hinh hinh;
	@Override
	public void setHinh(Hinh hinh) {
		this.hinh = hinh;
	}

	@Override
	public void hienThi() {
		System.out.println("Chu vi hinh chu nhat la : " + hinh.chuVi());
		System.out.println("Dien tich hinh chu nhat la : " + hinh.dienTich());
	}

}

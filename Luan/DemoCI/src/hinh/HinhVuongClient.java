package hinh;

import di.Hinh;
import di.HinhClient;

public class HinhVuongClient implements HinhClient{
	Hinh hinh;
	@Override
	public void setHinh(Hinh hinh) {
		this.hinh = hinh;
	}

	@Override
	public void xuat() {
		System.out.println(hinh.chuVi(3, 3));
		System.out.println(hinh.dienTich(3, 3));
	}
}

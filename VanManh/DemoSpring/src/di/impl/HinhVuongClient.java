package di.impl;

public class HinhVuongClient extends ChuNhatClient{
	@Override
	public void hienThi() {
		System.out.println("Chu vi hinh vuong la : " + hinh.chuVi());
		System.out.println("Dien tich hinh vuong la : " + hinh.dienTich());
	}
}

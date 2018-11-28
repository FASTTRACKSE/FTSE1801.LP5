package hinh;

import di.Hinh;

public class HinhVuong implements Hinh{

	@Override
	public double dienTich(double canh1, double canh2) {
		return canh1*canh2;
	}

	@Override
	public double chuVi(double canh1, double canh2) {
		return 2*(canh1+canh2);
	}
	
	
}

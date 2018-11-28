package bean;

public class HinhVuong extends ChuNhat{

	public HinhVuong(double canh) {
		super(canh, canh);
	}
	
	@Override
	public void xuat() {
		System.out.println("Day la hinh vuong");
		System.out.println("Chu vi: "+ chuVi());
		System.out.println("Dien tich: "+ dienTich());
	}
}

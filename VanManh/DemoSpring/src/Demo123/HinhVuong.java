package Demo123;

public class HinhVuong extends HinhChuNhat{

	public HinhVuong(double canh) {
		super(canh, canh);
	}
	
	@Override
	public void show() {
		System.out.println("Hinh vuong");
		System.out.println("Chu vi la :" + getChuVi());
		System.out.println("Dien tich la :" + getDienTich());
	}

}

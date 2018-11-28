package demoPolymorphism;

public class HinhChuNhat extends Hinh{
	private double dai;
	private double rong;
	
	public HinhChuNhat() {
		
	}
	public HinhChuNhat(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}
	public double getChuVi() {
		return (dai+rong)*2;
	}
	public double getDienTich() {
		return dai*rong;
	}
	
	public void xuat() {
		System.out.println("Đây là hình chữ nhật");
		super.xuat();
	}
}

package model.entity;

public class HinhChuNhat extends Hinh {
	private double dai;
	private double rong;
	
	public HinhChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	
	public double chuVi() {
		return (dai+rong)*2;
	}
	
	public double dienTich() {
		return dai*rong;
	}
	
	public void xuat() {
		System.out.println("Đây là hình chữ nhật có chiều dài " + dai + " và chiều rộng " + rong);
		System.out.println("Chu vi: " + chuVi());
		System.out.println("Diện tích: " + dienTich());
	}
}

package bean;


public class ChuNhat extends AllHinh{
	private double dai;
	private double rong;
	public ChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	@Override
	double chuVi() {
		return 2*(dai+rong);
	}
	@Override
	double dienTich() {
		return dai*rong;
	}
	@Override
	public void xuat() {
		System.out.println("Day la hinh chu nhat");
		super.xuat();
	}
	
}

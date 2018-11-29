package Demo123;

public class HinhChuNhat extends Hinh{
	private double cd;
	private double cr;
	
	public HinhChuNhat(double cd, double cr) {
		super();
		this.cd = cd;
		this.cr = cr;
	}

	@Override
	public double getChuVi() {
		return (cd+cr)*2;
	}

	@Override
	double getDienTich() {
		return cd*cr;
	}
	
	@Override
	public void show() {
		System.out.println("Hinh chu nhat");
		super.show();
	}
	
}

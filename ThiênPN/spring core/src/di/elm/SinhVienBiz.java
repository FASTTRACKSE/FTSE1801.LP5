package di.elm;

public class SinhVienBiz extends SinhVienFPT{
	private double marketing;
	private double sales;
	
	
	public SinhVienBiz(String hoTen, String nghanh, double marketing, double sales) {
		super(hoTen, nghanh);
		this.marketing = marketing;
		this.sales = sales;
	}


	@Override
	double getDiem() {
		return (marketing * 2 + sales) / 3;
	}
	
	@Override
	 public void xuat() {
		System.out.println("Sinh Viên Biz");
		super.xuat();
		System.out.println("marketing"+ marketing);
    	System.out.println("sales"+ sales);
    	System.out.println("Điểm TB SV: " + getDiem());
		System.out.println("Xếp loại SV: " + getHocLuc());
	}
}

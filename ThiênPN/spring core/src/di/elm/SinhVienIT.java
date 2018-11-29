package di.elm;

public class SinhVienIT extends SinhVienFPT{
	private double java;
	private double html;
	private double css;
	
	public SinhVienIT(String hoTen, String nghanh, double java, double html, double css) {
		super(hoTen, nghanh);
		this.java = java;
		this.html = html;
		this.css = css;
	}

	@Override
	double getDiem() {
		return (2*java+html+css)/4;
	}
    @Override
   public void xuat() {
    	System.out.println("Sinh Viên nghành IT với kết quả học tập");
    	super.xuat();
    	System.out.println("java"+ java);
    	System.out.println("html"+ html);
    	System.out.println("css"+ css);
    	System.out.println("Điểm TB SV: " + getDiem());
		System.out.println("Xếp loại SV: " + getHocLuc());
    }
}

package sinhvien;

public class Biz extends SinhVienFpt {
	private int diemSales;
	private int diemMaketing;

	public Biz() {
	}

	public Biz(String hoTen, String nganh, int diemSales, int diemMaketing) {
		super(hoTen, nganh);
		this.diemSales = diemSales;
		this.diemMaketing = diemMaketing;
	}

	public int getDiemSales() {
		return diemSales;
	}

	public void setDiemSales(int diemSales) {
		this.diemSales = diemSales;
	}

	public int getDiemMaketing() {
		return diemMaketing;
	}

	public void setDiemMaketing(int diemMaketing) {
		this.diemMaketing = diemMaketing;
	}

	@Override
	public double getDiem() {
		return (diemMaketing + diemSales) / 2;
	}

	@Override
	public void xuat() {
		System.out.println("Day la sinh vien biz");
		super.xuat();
	}
}

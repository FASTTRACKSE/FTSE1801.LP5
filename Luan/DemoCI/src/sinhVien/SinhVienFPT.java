package sinhVien;

public class SinhVienFPT extends SinhVien {
	private String hoTen;
	private String nganh;

	public SinhVienFPT(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	@Override
	String getTen() {
		return hoTen;
	}

	@Override
	String getNganh() {
		return nganh;
	}

	@Override
	double getDiem() {
		return 0;
	}
	
	@Override
	String getHocLuc() {
		String xl;
		if (getDiem() < 5) {
			xl = "Yếu";
		} else if (getDiem() < 6.5) {
			xl = "Trung Binh";
		} else if (getDiem() < 7.5) {
			xl = "Khá";
		} else if (getDiem() < 9) {
			xl = "Giỏi";
		} else {
			xl = "Xuất Sắc";
		}
		return xl;
	}
	@Override
	public void xuat() {
		super.xuat();
	}
}

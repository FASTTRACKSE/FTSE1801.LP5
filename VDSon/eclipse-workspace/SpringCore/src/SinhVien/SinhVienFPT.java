package SinhVien;

public abstract class SinhVienFPT {
	String hoTen;
	String nganh;

	public SinhVienFPT(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}

	abstract double getDiem();

	public String hocLuc() {
		if (getDiem() > 8) {
			return "Giỏi";
		} else if (getDiem() > 6.5) {
			return "Khá";
		} else if (getDiem() > 5) {
			return "Trung bình";
		} else {
			return "Yếu";
		}
	}

	public void xuat() {
		System.out.println("Tên sinh viên: " + hoTen);
		System.out.println("Ngành: " + nganh);
		System.out.println("Điểm " + getDiem());
		System.out.println("Học lực: " + hocLuc());
		System.out.println("----------------------------");
	}
}

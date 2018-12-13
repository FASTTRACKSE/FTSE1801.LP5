package fasttrackse.ftse1801.fbms.entity.vang_nghi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_ngay_nghi")
public class LoaiNghiPhep {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_loai_nghi")
	private int maLoaiNghi;

	@Column(name = "ten_ngay_nghi")
	private String tenNgayNghi;

	@Column(name = "so_ngay_duoc_nghi")
	private int soNgayNghi;

	public int getMaLoaiNghi() {
		return maLoaiNghi;
	}

	public void setMaLoaiNghi(int maLoaiNghi) {
		this.maLoaiNghi = maLoaiNghi;
	}

	public String getTenNgayNghi() {
		return tenNgayNghi;
	}

	public void setTenNgayNghi(String tenNgayNghi) {
		this.tenNgayNghi = tenNgayNghi;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

}

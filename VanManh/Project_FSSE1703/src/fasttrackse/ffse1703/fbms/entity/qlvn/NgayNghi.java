package fasttrackse.ffse1703.fbms.entity.qlvn;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="ngay_nghi")
public class NgayNghi{

	@Id
	@NotNull
	@Column(name = "ma_nhan_vien")
	private int maNhanVien;
	
	@NotEmpty
	@Column(name="ten_nhan_vien")
	private String tenNhanVien;
	
	@Column(name="so_ngay_da_nghi")
	private int soNgayDaNghi;
	
	@Column(name="so_ngay_con_lai")
	private int soNgayConLai;

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public int getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(int soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	
}

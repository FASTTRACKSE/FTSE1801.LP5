package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="thong_tin_chung_chi")
public class ThongTinChungChi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_chung_chi")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanSu hoSoNhanVien;
	
	@Column(name="ten_chung_chi")
	private String tenChungChi;
	
	@Column(name = "don_vi_cap", nullable = false)
	private String donViCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap", nullable = false)
	private Date ngayCap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanSu getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanSu hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public String getTenChungChi() {
		return tenChungChi;
	}

	public void setTenChungChi(String tenChungChi) {
		this.tenChungChi = tenChungChi;
	}

	public String getDonViCap() {
		return donViCap;
	}

	public void setDonViCap(String donViCap) {
		this.donViCap = donViCap;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	
	
}

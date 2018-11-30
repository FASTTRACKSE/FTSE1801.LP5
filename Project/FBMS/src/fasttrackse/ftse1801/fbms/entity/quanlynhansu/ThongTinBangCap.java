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
@Table(name = "thong_tin_bang_cap")
public class ThongTinBangCap {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanVien hoSoNhanVien;

	@Column(name = "ten_bang_cap", nullable = false)
	private String tenBangCap;

	@Column(name = "loai_bang_cap", nullable = false)
	private String loaiBangCap;

	@Column(name = "don_vi_cap", nullable = false)
	private String donViCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_cap", nullable = false)
	private Date ngayCap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanVien getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVien hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public String getTenBangCap() {
		return tenBangCap;
	}

	public void setTenBangCap(String tenBangCap) {
		this.tenBangCap = tenBangCap;
	}

	public String getLoaiBangCap() {
		return loaiBangCap;
	}

	public void setLoaiBangCap(String loaiBangCap) {
		this.loaiBangCap = loaiBangCap;
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
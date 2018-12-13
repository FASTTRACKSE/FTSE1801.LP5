package fasttrackse.ftse1801.fbms.entity.vang_nghi;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name = "don_xin_nghi")
public class DonXinNghi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_don_xin_nghi")
	private int idDonXinPhep;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	private TinhTrangNghi maNhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban")
	private PhongBan idPhongBan;

	@ManyToOne
	@JoinColumn(name = "ma_loai_nghi")
	private LoaiNghiPhep idLoaiNghi;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "thoi_gian_bat_dau", nullable = false)
	private Date thoiGianBatDau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "thoi_gian_ket_thuc", nullable = false)
	private Date thoiGianKetThuc;

	@NotNull
	@Min(1)
	@Max(12)
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;

	@Column(name = "ghi_chu")
	@NotEmpty()
	@Size(max = 255)
	private String ghiChu;

	@ManyToOne
	@JoinColumn(name = "ma_trang_thai")
	private TrangThaiVN maTrangThai;

	public int getIdDonXinPhep() {
		return idDonXinPhep;
	}

	public void setIdDonXinPhep(int idDonXinPhep) {
		this.idDonXinPhep = idDonXinPhep;
	}

	public TinhTrangNghi getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(TinhTrangNghi maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public PhongBan getidPhongBan() {
		return idPhongBan;
	}

	public void setidPhongBan(PhongBan idPhongBan) {
		this.idPhongBan = idPhongBan;
	}

	public LoaiNghiPhep getIdLoaiNghi() {
		return idLoaiNghi;
	}

	public void setIdLoaiNghi(LoaiNghiPhep idLoaiNghi) {
		this.idLoaiNghi = idLoaiNghi;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public TrangThaiVN getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThaiVN maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
}
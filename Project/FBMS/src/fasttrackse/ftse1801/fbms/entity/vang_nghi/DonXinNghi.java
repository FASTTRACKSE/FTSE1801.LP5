package fasttrackse.ftse1801.fbms.entity.vang_nghi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ftse1801.fbms.entity.security.HoSoNhanVien;
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
	private HoSoNhanVien maNhanVien;
	
	@JoinColumn(name = "ma_phong_ban")
	private PhongBan maPhongBan;
	
	@ManyToOne
	@JoinColumn(name = "id_loai_nghi")
	private LoaiNghiPhep idLoaiNghi;
	
	@NotNull
	@Column(name = "thoi_gian_bat_dau")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private String thoiGianBatDau;
	
	@NotNull
	@Column(name = "thoi_gian_ket_thuc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private String thoiGianKetThuc;
	
	@Column(name = "ghi_chu")
	@NotEmpty()
	@Size(max=255)
	private String ghiChu;
	
	@ManyToOne
	@JoinColumn(name = "trang_thai")
	private TrangThaiVN maTrangThai;

	public int getIdDonXinPhep() {
		return idDonXinPhep;
	}

	public void setIdDonXinPhep(int idDonXinPhep) {
		this.idDonXinPhep = idDonXinPhep;
	}

	public HoSoNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public PhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(PhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public LoaiNghiPhep getIdLoaiNghi() {
		return idLoaiNghi;
	}

	public void setIdLoaiNghi(LoaiNghiPhep idLoaiNghi) {
		this.idLoaiNghi = idLoaiNghi;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
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

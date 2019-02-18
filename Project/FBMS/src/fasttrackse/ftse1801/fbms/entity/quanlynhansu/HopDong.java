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
@Table(name = "hop_dong")
public class HopDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_hop_dong", nullable = false)
	private int maHopDong;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanSu maNhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_loai_hop_dong", nullable = false)
	private LoaiHopDong maLoaiHopDong;

	@Column(name = "luong_thang_13", nullable = false)
	private int luongThang13;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ky", nullable = false)
	private Date ngayKy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "hop_dong_tu_ngay", nullable = false)
	private Date hopDongTuNgay;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "hop_dong_den_ngay", nullable = false)
	private Date hopDongDenNgay;

	@Column(name = "so_ngay_phep", nullable = false)
	private int soNgayPhep;

	@Column(name = "trang_thai_hop_dong", nullable = false)
	private int trangThai;

	@Column(name = "isdelete", nullable = false)
	private int isdelete;

	public int getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}

	public HoSoNhanSu getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanSu maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public LoaiHopDong getMaLoaiHopDong() {
		return maLoaiHopDong;
	}

	public void setMaLoaiHopDong(LoaiHopDong maLoaiHopDong) {
		this.maLoaiHopDong = maLoaiHopDong;
	}

	public int getLuongThang13() {
		return luongThang13;
	}

	public void setLuongThang13(int luongThang13) {
		this.luongThang13 = luongThang13;
	}

	public int getSoNgayPhep() {
		return soNgayPhep;
	}

	public void setSoNgayPhep(int soNgayPhep) {
		this.soNgayPhep = soNgayPhep;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Date getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}

	public Date getHopDongTuNgay() {
		return hopDongTuNgay;
	}

	public void setHopDongTuNgay(Date hopDongTuNgay) {
		this.hopDongTuNgay = hopDongTuNgay;
	}

	public Date getHopDongDenNgay() {
		return hopDongDenNgay;
	}

	public void setHopDongDenNgay(Date hopDongDenNgay) {
		this.hopDongDenNgay = hopDongDenNgay;
	}

}

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanSu hoSoNhanVien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_loai_hop_dong", nullable = false)
	private LoaiHopDong loaiHopDong;

	@Column(name = "luong_thang_13", nullable = false)
	private String luongThang13;

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
	private Date hopDongdenNgay;

	public int getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}

	public HoSoNhanSu getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanSu hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public LoaiHopDong getLoaiHopDong() {
		return loaiHopDong;
	}

	public void setLoaiHopDong(LoaiHopDong loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}

	public String getLuongThang13() {
		return luongThang13;
	}

	public void setLuongThang13(String luongThang13) {
		this.luongThang13 = luongThang13;
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

	public Date getHopDongdenNgay() {
		return hopDongdenNgay;
	}

	public void setHopDongdenNgay(Date hopDongdenNgay) {
		this.hopDongdenNgay = hopDongdenNgay;
	}

}

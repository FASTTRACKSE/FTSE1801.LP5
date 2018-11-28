package fasttrackse.ffse1703.fbms.entity.qlvn2;


import java.util.Date;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "don_xin_phep")
public class DonXinPhepEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	private SoNgayNghiEntity ngayNghi;
	
    @Column(name ="ho_dem")
    private String hoDem;
    
    @Column(name ="ma_phong_ban")
    private String maPhongBan;

	@Column(name = "ngay_bat_dau")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ngayBatDau;

    
	@Column(name = "ngay_ket_thuc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Không thể để trống")
	@Temporal(TemporalType.DATE)
	private Date ngayKetThuc;
	
	@NotNull
	@Min(1)
	@Max(12)
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;
	
	

	@ManyToOne
	@JoinColumn(name = "ly_do")
	private LyDoEntity lyDo;

	@NotEmpty(message = "Không thể để trống")
	@Column(name = "ghi_chu")
	private String ghiChu;
	


	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	@Column(name = "ghi_chu_truong_phong")
	private String ghiChuTruongPhong;


	@ManyToOne
	@JoinColumn(name = "ten_trang_thai")
	private TrangThaiEntity trangThai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	



	


	public SoNgayNghiEntity getNgayNghi() {
		return ngayNghi;
	}

	public void setNgayNghi(SoNgayNghiEntity ngayNghi) {
		this.ngayNghi = ngayNghi;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	

	public LyDoEntity getLyDo() {
		return lyDo;
	}

	public void setLyDo(LyDoEntity lyDo) {
		this.lyDo = lyDo;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getGhiChuTruongPhong() {
		return ghiChuTruongPhong;
	}

	public void setGhiChuTruongPhong(String ghiChuTruongPhong) {
		this.ghiChuTruongPhong = ghiChuTruongPhong;
	}

	public TrangThaiEntity getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiEntity trangThai) {
		this.trangThai = trangThai;
	}

}


	
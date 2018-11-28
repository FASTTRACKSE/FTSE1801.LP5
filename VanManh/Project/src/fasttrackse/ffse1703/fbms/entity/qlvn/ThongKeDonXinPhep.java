package fasttrackse.ffse1703.fbms.entity.qlvn;
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
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "thong_ke_don_xin_phep")
public class ThongKeDonXinPhep {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="ma_nhan_vien")
	private NgayNghi ngayNghi;
	
	@Column(name="ma_phong_ban")
	private String maPhongBan;
	
	@Column(name="ten_nhan_vien")
	private String tenNhanVien;
 
	@NotNull
	@Column(name = "ngay_bat_dau")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ngayBatDau;

	@NotNull
	@Column(name = "ngay_ket_thuc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ngayKetThuc;

	@NotNull
	@Min(1)
	@Max(12)
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;

	@ManyToOne
	@JoinColumn(name = "ly_do")
	private LyDoXinNghi lyDo;

	@Column(name = "ghi_chu")
	@NotEmpty()
	@Size(max=255)
	private String ghiChu;

	@Column(name = "ghi_chu_truong_phong")
	private String ghiChuTruongPhong;

	@ManyToOne
	@JoinColumn(name = "trang_thai")
	private TrangThaiVN trangThai;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public NgayNghi getNgayNghi() {
		return ngayNghi;
	}

	public void setNgayNghi(NgayNghi ngayNghi) {
		this.ngayNghi = ngayNghi;
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

	public LyDoXinNghi getLyDo() {
		return lyDo;
	}

	public void setLyDo(LyDoXinNghi lyDo) {
		this.lyDo = lyDo;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
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

	public TrangThaiVN getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiVN trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	
	
}

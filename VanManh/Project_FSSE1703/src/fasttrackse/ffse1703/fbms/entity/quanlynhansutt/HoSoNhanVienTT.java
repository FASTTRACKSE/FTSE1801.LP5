package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ho_so_nhan_vien_tt")
public class HoSoNhanVienTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nhan_vien", unique = true, nullable = false )
	private int maNhanVien;

	@Column(name = "ten_nhan_vien" , nullable = false, length = 100) 
	@NotEmpty(message="must not be empty")
	private String tenNhanVien;

	@Column(name = "anh_dai_dien" , nullable = false, length = 100) 
	private String anhDaiDien;

	@Column(name = "nam_sinh")
	@NotEmpty(message="must not be empty")
	private String namSinh;

	@Column(name = "gioi_tinh", nullable = false) 
	@NotNull 
	private Integer gioiTinh;

	@Column(name = "dia_chi" , nullable = false, length = 250) 
	@NotEmpty(message="must not be empty")
	private String diaChi;

	// bi-directional many-to-one association to XaPhuong
	@ManyToOne
	@JoinColumn(name = "ma_xa_phuong" , nullable = false) 
	@NotNull
	private XaPhuongTT xaPhuong;

	// bi-directional many-to-one association to QuanHuyen
	@ManyToOne
	@JoinColumn(name = "ma_quan_huyen" , nullable = false) 
	@NotNull
	private QuanHuyenTT quanHuyen;

	// bi-directional many-to-one association to TinhThanhPho
	@ManyToOne
	@JoinColumn(name = "ma_thanh_pho" , nullable = false) 
	@NotNull
	private TinhThanhTT thanhPho;

	@Column(name = "so_dien_thoai" , nullable = false, length = 11) 
	@NotEmpty(message="must not be empty")
	private String soDienThoai;

	@Column(name = "email", nullable = false, length = 50) 
	@NotEmpty(message="must not be empty")
	 @Email
	private String email;

	// bi-directional many-to-one association to TinhTrangHonNhan
	@ManyToOne
	@JoinColumn(name = "ma_tinh_trang_hon_nhan", nullable = false) 
	@NotNull
	private TinhTrangHonNhanTT tinhTrangHonNhan;

	// bi-directional many-to-one association to QuocTich
	@ManyToOne
	@JoinColumn(name = "ma_quoc_tich" , nullable = false) 
	@NotNull
	private QuocTichTT quocTich;

	// bi-directional many-to-one association to LoaiHopDong
	@ManyToOne/*(fetch = FetchType.LAZY)*/
	@JoinColumn(name = "ma_dan_toc", nullable = false)
	@NotNull
	private DanTocTT danToc;

	// bi-directional many-to-one association to DanToc
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "ma_dan_toc", nullable = false) private DanTocTT danToc;
	 */

	@Column(name = "so_cmnd", nullable = false, length = 9) 
	@NotEmpty(message="must not be empty")
	private String soCmnd;

	@Column(name = "noi_cap" , nullable = false, length = 50) 
	@NotEmpty(message="must not be empty")
	private String noiCap;

	@Column(name = "ngay_cap", nullable = false )
	@NotEmpty(message="must not be empty")
	private String ngayCap;

	// bi-directional many-to-one association to PhongBan
	@ManyToOne
	@JoinColumn(name = "ma_phong_ban" , nullable = false )
	@NotNull
	private PhongBanTT phongBan;

	// bi-directional many-to-one association to ChucDanh
	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh", nullable = false )
	@NotNull
	private ChucDanhTT chucDanh;

	@Column(name = "trang_thai", nullable = false )
	@NotNull
	private Integer trangThai;

	@Column(name = "isdelete")
	private Integer isdelete;
	
	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	// bi-directional many-to-one association to HopDong
	@OneToMany(mappedBy = "hoSoNhanVienTT")
	private List<HopDongTT> hopDongs;

	// bi-directional many-to-one association to ThongTinBangCap
	@OneToMany(mappedBy = "hoSoNhanVienTT")
	private List<ThongTinBangCapTT> thongTinBangCaps;

	

	public HoSoNhanVienTT() {
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public XaPhuongTT getXaPhuong() {
		return xaPhuong;
	}

	public void setXaPhuong(XaPhuongTT xaPhuong) {
		this.xaPhuong = xaPhuong;
	}

	public QuanHuyenTT getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(QuanHuyenTT quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public TinhThanhTT getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(TinhThanhTT thanhPho) {
		this.thanhPho = thanhPho;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TinhTrangHonNhanTT getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(TinhTrangHonNhanTT tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public QuocTichTT getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(QuocTichTT quocTich) {
		this.quocTich = quocTich;
	}

	public DanTocTT getDanToc() {
		return danToc;
	}

	public void setDanToc(DanTocTT danToc) {
		this.danToc = danToc;
	}

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}

	public PhongBanTT getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBanTT phongBan) {
		this.phongBan = phongBan;
	}

	public ChucDanhTT getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(ChucDanhTT chucDanh) {
		this.chucDanh = chucDanh;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public List<HopDongTT> getHopDongs() {
		return hopDongs;
	}

	public void setHopDongs(List<HopDongTT> hopDongs) {
		this.hopDongs = hopDongs;
	}

	public List<ThongTinBangCapTT> getThongTinBangCaps() {
		return thongTinBangCaps;
	}

	public void setThongTinBangCaps(List<ThongTinBangCapTT> thongTinBangCaps) {
		this.thongTinBangCaps = thongTinBangCaps;
	}
}
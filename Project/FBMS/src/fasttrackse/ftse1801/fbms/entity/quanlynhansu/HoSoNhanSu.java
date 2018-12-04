package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ftse1801.fbms.entity.security.ChucDanh;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name = "ho_so_nhan_su")
public class HoSoNhanSu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nhan_vien", nullable = false)
	private int maNhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	private PhongBan maPhongBan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_chuc_danh", nullable = false)
	private ChucDanh maChucDanh;

	@Column(name = "ho_dem", nullable = false)
	private String hoDem;

	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "anh_dai_dien", nullable = false)
	private String avatar;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh", nullable = false)
	private Date namSinh;

	@Column(name = "gioi_tinh", nullable = false)
	private int gioiTinh;

	@Column(name = "tinh_trang_hon_nhan", nullable = false)
	private int tinhTrangHonNhan;

	@Column(name = "que_quan", nullable = false)
	private String queQuan;

	@Column(name = "dan_toc", nullable = false)
	private String danToc;

	@Column(name = "noi_tam_tru", nullable = false)
	private String noiTamTru;

	@Column(name = "so_dien_thoai", nullable = false)
	private String soDienThoai;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "so_cmnd", nullable = false)
	private String soCMND;

	@Column(name = "noi_cap", nullable = false)
	private String noiCap;

	@Column(name = "trang_thai", nullable = false)
	private int trangThai;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap", nullable = false)
	private Date ngayCap;

	// ket noi 2 chieu @ManyToOne voi class ThongTinGiaDinh
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<ThongTinGiaDinh> thongTinGiaDinh;

	// ket noi 2 chieu @ManyToOne voi class ThongTinBangCap
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<ThongTinBangCap> thongTinBangCap;

	// ket noi 2 chieu @ManyToOne voi class ThongTinChungChi
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<ThongTinChungChi> thongTinChungChi;

	// ket noi 2 chieu @ManyToOne voi class KyNang
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<KyNang> kyNang;

	// ket noi 2 chieu @ManyToOne voi class HopDong
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<HopDong> hopDong;

	public HoSoNhanSu() {
	}

	public List<KyNang> getKyNang() {
		return kyNang;
	}

	public void setKyNang(List<KyNang> kyNang) {
		this.kyNang = kyNang;
	}

	public List<HopDong> getHopDong() {
		return hopDong;
	}

	public void setHopDong(List<HopDong> hopDong) {
		this.hopDong = hopDong;
	}

	public List<ThongTinChungChi> getThongTinChungChi() {
		return thongTinChungChi;
	}

	public void setThongTinChungChi(List<ThongTinChungChi> thongTinChungChi) {
		this.thongTinChungChi = thongTinChungChi;
	}

	public List<ThongTinBangCap> getThongTinBangCap() {
		return thongTinBangCap;
	}

	public void setThongTinBangCap(List<ThongTinBangCap> thongTinBangCap) {
		this.thongTinBangCap = thongTinBangCap;
	}

	public List<ThongTinGiaDinh> getThongTinGiaDinh() {
		return thongTinGiaDinh;
	}

	public void setThongTinGiaDinh(List<ThongTinGiaDinh> thongTinGiaDinh) {
		this.thongTinGiaDinh = thongTinGiaDinh;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public PhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(PhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public ChucDanh getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(ChucDanh maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(int tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNoiTamTru() {
		return noiTamTru;
	}

	public void setNoiTamTru(String noiTamTru) {
		this.noiTamTru = noiTamTru;
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

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String toString() {
		return "HoSoNhanVien [maNhanVien=" + maNhanVien + ", anhDaiDien=" + avatar + ", email=" + email + ", gioiTinh="
				+ gioiTinh + ", hoDem=" + hoDem + ", namSinh=" + namSinh + ", soDienThoai=" + soDienThoai + ", ten="
				+ ten + ", trangThai=" + trangThai + ", phongBan=" + maPhongBan + ", chucDanh=" + maChucDanh + "]";
	}

}

package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ho_so_nhan_vien")
public class HoSoNhanVien {
	@Id
	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban")
	private PhongBan maPhongBan;

	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh")
	private ChucDanh maChucDanh;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "anh_dai_dien")
	private String avatar;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "nam_sinh")
	private Date namSinh;

	@Column(name = "gioi_tinh")
	private String gioiTinh;

	@Column(name = "tinh_trang_hon_nhan")
	private String tinhTrangHonNhan;

	@Column(name = "que_quan")
	private String queQuan;

	@Column(name = "dan_toc")
	private String danToc;

	@Column(name = "noi_tam_tru")
	private String noiTamTru;

	@Column(name = "so_dien_thoai")
	private int soDienThoai;

	@Column(name = "email")
	private String email;

	@Column(name = "so_cmnd")
	private int soCMND;

	@Column(name = "noi_cap")
	private String noiCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_cap")
	private Date ngayCap;

	// ket noi 2 chieu @ManyToOne voi class ThongTinGiaDinh
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<ThongTinGiaDinh> thongTinGiaDinh;

	// ket noi 2 chieu @ManyToOne voi class ThongTinBangCap
	@OneToMany(mappedBy = "hoSoNhanVien")
	private List<ThongTinBangCap> thongTinBangCap;

	public HoSoNhanVien() {
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

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
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

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
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

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(int soCMND) {
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

}

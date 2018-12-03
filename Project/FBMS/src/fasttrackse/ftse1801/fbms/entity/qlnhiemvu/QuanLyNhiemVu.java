package fasttrackse.ftse1801.fbms.entity.qlnhiemvu;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanVien;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name = "quan_li_nhiem_vu")
public class QuanLyNhiemVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name="ma_du_an")
	private int maDuAn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_loai_cong_viec")
	private LoaiCongViec idLoaiCongVien;

	@Column(name = "ten_cong_viec")
	private String tenCongViec;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "thoi_gian_bat_dau")
	private Date thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	private Date thoiGianKetThuc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanVien idNhanVien;

	@Column(name = "tg_du_kien_hoan_thanh")
	private int thoiGianDuKienHoanThanh;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_trang_thai")
	private TrangThai idTrangThai;

	@Column(name = "is_delete")
	private int isDelete;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban")
	private PhongBan idPhongBan;
	
	@Column(name="ma_vai_tro")
	private String maVaiTro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(int maDuAn) {
		this.maDuAn = maDuAn;
	}

	public LoaiCongViec getIdLoaiCongVien() {
		return idLoaiCongVien;
	}

	public void setIdLoaiCongVien(LoaiCongViec idLoaiCongVien) {
		this.idLoaiCongVien = idLoaiCongVien;
	}

	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public HoSoNhanVien getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(HoSoNhanVien idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public int getThoiGianDuKienHoanThanh() {
		return thoiGianDuKienHoanThanh;
	}

	public void setThoiGianDuKienHoanThanh(int thoiGianDuKienHoanThanh) {
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
	}

	public TrangThai getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(TrangThai idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public PhongBan getIdPhongBan() {
		return idPhongBan;
	}

	public void setIdPhongBan(PhongBan idPhongBan) {
		this.idPhongBan = idPhongBan;
	}

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public QuanLyNhiemVu(int id, int maDuAn, LoaiCongViec idLoaiCongVien, String tenCongViec, String moTa,
			Date thoiGianBatDau, Date thoiGianKetThuc, HoSoNhanVien idNhanVien, int thoiGianDuKienHoanThanh,
			TrangThai idTrangThai, int isDelete, PhongBan idPhongBan, String maVaiTro) {
		this.id = id;
		this.maDuAn = maDuAn;
		this.idLoaiCongVien = idLoaiCongVien;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.idNhanVien = idNhanVien;
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
		this.idTrangThai = idTrangThai;
		this.isDelete = isDelete;
		this.idPhongBan = idPhongBan;
		this.maVaiTro = maVaiTro;
	}

	public QuanLyNhiemVu() {
	}

}

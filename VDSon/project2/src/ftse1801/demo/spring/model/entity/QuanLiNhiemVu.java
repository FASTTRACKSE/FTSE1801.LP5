package ftse1801.demo.spring.model.entity;

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

@Entity
@Table(name = "quan_li_nhiem_vu")
public class QuanLiNhiemVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	private int maDuAn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_loai_cong_viec")
	private LoaiCongViec loaiCongViec;

	@Column(name = "ten_cong_viec")
	private String tenCongViec;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "thoi_gian_bat_dau")
	private Date thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	private Date thoiGianKetThuc;

	private int maNhanVien;

	@Column(name = "tg_du_kien_hoan_thanh")
	private String tgDuKienHoanThanh;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_trang_thai")
	private TrangThai iDTrangThai;

	@Column(name = "is_delete")
	private int isDelete;

	public QuanLiNhiemVu(int iD, int maDuAn, LoaiCongViec loaiCongViec, String tenCongViec, String moTa,
			Date thoiGianBatDau, Date thoiGianKetThuc, int maNhanVien, String tgDuKienHoanThanh, TrangThai iDTrangThai,
			int isDelete) {
		super();
		ID = iD;
		this.maDuAn = maDuAn;
		this.loaiCongViec = loaiCongViec;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.maNhanVien = maNhanVien;
		this.tgDuKienHoanThanh = tgDuKienHoanThanh;
		this.iDTrangThai = iDTrangThai;
		this.isDelete = isDelete;
	}

	public QuanLiNhiemVu() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public LoaiCongViec getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
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

	public String getTgDuKienHoanThanh() {
		return tgDuKienHoanThanh;
	}

	public void setTgDuKienHoanThanh(String tgDuKienHoanThanh) {
		this.tgDuKienHoanThanh = tgDuKienHoanThanh;
	}

	public TrangThai getiDTrangThai() {
		return iDTrangThai;
	}

	public void setiDTrangThai(TrangThai iDTrangThai) {
		this.iDTrangThai = iDTrangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}

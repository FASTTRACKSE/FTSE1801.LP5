package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@SuppressWarnings("serial")
@Table(name = "danh_gia_nhan_vien")
@Entity
public class DanhGiaNhanVien implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_ky_danh_gia", referencedColumnName = "ma_ky_danh_gia", insertable = true, updatable = true)
	private KyDanhGia kyDanhGia;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	private PhongBan phongBan;
	
	@Column(name = "nhan_vien_danh_gia")
	private int nhanVienDanhGia;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = true, updatable = true)
	private HoSoNhanVien nhanVien;

	@Column(name = "ky_luat_cong_viec")
	private String kyLuatCongViec;

	@Column(name = "tinh_than_lam_viec")
	private String tinhThanLamViec;

	@Column(name = "khoi_luong_cong_viec")
	private String khoiLuongCongViec;

	@Column(name = "ket_qua_cong_viec")
	private String ketQuaCongViec;

	@Column(name = "ky_nang_tich_luy")
	private String kyNangTichLuy;

	@Column(name = "dinh_huong")
	private String dinhHuong;

	@Column(name = "xep_loai")
	@NotNull
	private int xepLoai;

	@Column(name = "is_delete")
	private int isDelete;

	public DanhGiaNhanVien() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KyDanhGia getKyDanhGia() {
		return kyDanhGia;
	}

	public void setKyDanhGia(KyDanhGia kyDanhGia) {
		this.kyDanhGia = kyDanhGia;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public int getNhanVienDanhGia() {
		return nhanVienDanhGia;
	}

	public void setNhanVienDanhGia(int nhanVienDanhGia) {
		this.nhanVienDanhGia = nhanVienDanhGia;
	}

	public HoSoNhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(HoSoNhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getKyLuatCongViec() {
		return kyLuatCongViec;
	}

	public void setKyLuatCongViec(String kyLuatCongViec) {
		this.kyLuatCongViec = kyLuatCongViec;
	}

	public String getTinhThanLamViec() {
		return tinhThanLamViec;
	}

	public void setTinhThanLamViec(String tinhThanLamViec) {
		this.tinhThanLamViec = tinhThanLamViec;
	}

	public String getKhoiLuongCongViec() {
		return khoiLuongCongViec;
	}

	public void setKhoiLuongCongViec(String khoiLuongCongViec) {
		this.khoiLuongCongViec = khoiLuongCongViec;
	}

	public String getKetQuaCongViec() {
		return ketQuaCongViec;
	}

	public void setKetQuaCongViec(String ketQuaCongViec) {
		this.ketQuaCongViec = ketQuaCongViec;
	}

	public String getKyNangTichLuy() {
		return kyNangTichLuy;
	}

	public void setKyNangTichLuy(String kyNangTichLuy) {
		this.kyNangTichLuy = kyNangTichLuy;
	}

	public String getDinhHuong() {
		return dinhHuong;
	}

	public void setDinhHuong(String dinhHuong) {
		this.dinhHuong = dinhHuong;
	}

	public int getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(int xepLoai) {
		this.xepLoai = xepLoai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}

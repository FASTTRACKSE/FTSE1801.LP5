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
import javax.persistence.Table;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@SuppressWarnings("serial")
@Table(name = "truong_phong_danh_gia")
@Entity
public class TruongPhongDanhGia implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_ky_danh_gia",  referencedColumnName="ma_ky_danh_gia", insertable = true, updatable = true)
	private KyDanhGia kyDanhGia;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_phong_ban",  referencedColumnName="ma_phong_ban", insertable = true, updatable = true)
	private PhongBan phongBan;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "nhan_vien",  referencedColumnName="ma_nhan_vien", insertable = true, updatable = true)
	private HoSoNhanVien nhanVien;

	@Column(name = "ky_luat_cong_viec")
	private int kyLuatCongViec;

	@Column(name = "tinh_than_lam_viec")
	private int tinhThanLamViec;

	@Column(name = "khoi_luong_cong_viec")
	private int khoiLuongCongViec;

	@Column(name = "ket_qua_cong_viec")
	private int ketQuaCongViec;

	@Column(name = "ky_nang_tich_luy")
	private int kyNangTichLuy;

	@Column(name = "nhan_xet_chung")
	private String nhanXet;

	@Column(name = "xep_loai")
	private int xepLoai;

	@Column(name = "is_delete")
	private int isDelete;

	public TruongPhongDanhGia() {
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

	public HoSoNhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(HoSoNhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getKyLuatCongViec() {
		return kyLuatCongViec;
	}

	public void setKyLuatCongViec(int kyLuatCongViec) {
		this.kyLuatCongViec = kyLuatCongViec;
	}

	public int getTinhThanLamViec() {
		return tinhThanLamViec;
	}

	public void setTinhThanLamViec(int tinhThanLamViec) {
		this.tinhThanLamViec = tinhThanLamViec;
	}

	public int getKhoiLuongCongViec() {
		return khoiLuongCongViec;
	}

	public void setKhoiLuongCongViec(int khoiLuongCongViec) {
		this.khoiLuongCongViec = khoiLuongCongViec;
	}

	public int getKetQuaCongViec() {
		return ketQuaCongViec;
	}

	public void setKetQuaCongViec(int ketQuaCongViec) {
		this.ketQuaCongViec = ketQuaCongViec;
	}

	public int getKyNangTichLuy() {
		return kyNangTichLuy;
	}

	public void setKyNangTichLuy(int kyNangTichLuy) {
		this.kyNangTichLuy = kyNangTichLuy;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
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

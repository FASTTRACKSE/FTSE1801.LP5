package fasttrackse.ftse1801.fbms.entity.quantridanhgia;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name="danh_gia_ban_than")
public class DanhGiaBanThan implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = true, updatable = true)
	private HoSoNhanSu nhanVien;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	private PhongBan phongBan;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_ky_danh_gia", referencedColumnName = "ma_ky_danh_gia", insertable = true, updatable = true)
	private KyDanhGia kyDanhGia;
	
	@Column(name="ky_luat_cong_viec_danh_gia")
	private int kyLuatCongVieccDanhGia;
	
	@Column(name="ky_luat_cong_viec_mo_ta")
	private String kyLuatCongVieccMoTa;
	
	@Column(name="tinh_than_lam_viec_danh_gia")
	private int tinhThanLamViecDanhGia;
	
	@Column(name="tinh_than_lam_viec_mo_ta")
	private String tinhThanLamViecMoTa;
	
	@Column(name="khoi_luong_cong_viec_danh_gia")
	private int khoiLuongCongViecDanhGia;
	
	@Column(name="khoi_luong_cong_viec_mo_ta")
	private String khoiLuongCongViecMoTa;
	
	@Column(name="ket_qua_cong_viec_danh_gia")
	private int ketQuaCongViecDanhGia;
	
	@Column(name="ket_qua_cong_viec_mo_ta")
	private String ketQuaCongViecMoTa;

	@Column(name="ki_nang_tich_luy_danh_gia")
	private int kiNangTichLuyDanhGia;
	
	@Column(name="ki_nang_tich_luy_mo_ta")
	private String kiNangTichLuyMoTa;
	
	@Column(name="dinh_huong")
	private String dinhHuong;
	
	@Column(name="danh_gia_tong_the")
	private int danhGiaTongThe;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = true, updatable = true)
	private TrangThaiDanhGia trangThai;
	
	@Column(name="is_delete")
	private int is_delete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanSu getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(HoSoNhanSu nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public KyDanhGia getKyDanhGia() {
		return kyDanhGia;
	}

	public void setKyDanhGia(KyDanhGia kyDanhGia) {
		this.kyDanhGia = kyDanhGia;
	}

	public int getKyLuatCongVieccDanhGia() {
		return kyLuatCongVieccDanhGia;
	}

	public void setKyLuatCongVieccDanhGia(int kyLuatCongVieccDanhGia) {
		this.kyLuatCongVieccDanhGia = kyLuatCongVieccDanhGia;
	}

	public String getKyLuatCongVieccMoTa() {
		return kyLuatCongVieccMoTa;
	}

	public void setKyLuatCongVieccMoTa(String kyLuatCongVieccMoTa) {
		this.kyLuatCongVieccMoTa = kyLuatCongVieccMoTa;
	}

	public int getTinhThanLamViecDanhGia() {
		return tinhThanLamViecDanhGia;
	}

	public void setTinhThanLamViecDanhGia(int tinhThanLamViecDanhGia) {
		this.tinhThanLamViecDanhGia = tinhThanLamViecDanhGia;
	}

	public String getTinhThanLamViecMoTa() {
		return tinhThanLamViecMoTa;
	}

	public void setTinhThanLamViecMoTa(String tinhThanLamViecMoTa) {
		this.tinhThanLamViecMoTa = tinhThanLamViecMoTa;
	}

	public int getKhoiLuongCongViecDanhGia() {
		return khoiLuongCongViecDanhGia;
	}

	public void setKhoiLuongCongViecDanhGia(int khoiLuongCongViecDanhGia) {
		this.khoiLuongCongViecDanhGia = khoiLuongCongViecDanhGia;
	}

	public String getKhoiLuongCongViecMoTa() {
		return khoiLuongCongViecMoTa;
	}

	public void setKhoiLuongCongViecMoTa(String khoiLuongCongViecMoTa) {
		this.khoiLuongCongViecMoTa = khoiLuongCongViecMoTa;
	}

	public int getKetQuaCongViecDanhGia() {
		return ketQuaCongViecDanhGia;
	}

	public void setKetQuaCongViecDanhGia(int ketQuaCongViecDanhGia) {
		this.ketQuaCongViecDanhGia = ketQuaCongViecDanhGia;
	}

	public String getKetQuaCongViecMoTa() {
		return ketQuaCongViecMoTa;
	}

	public void setKetQuaCongViecMoTa(String ketQuaCongViecMoTa) {
		this.ketQuaCongViecMoTa = ketQuaCongViecMoTa;
	}

	public int getKiNangTichLuyDanhGia() {
		return kiNangTichLuyDanhGia;
	}

	public void setKiNangTichLuyDanhGia(int kiNangTichLuyDanhGia) {
		this.kiNangTichLuyDanhGia = kiNangTichLuyDanhGia;
	}

	public String getKiNangTichLuyMoTa() {
		return kiNangTichLuyMoTa;
	}

	public void setKiNangTichLuyMoTa(String kiNangTichLuyMoTa) {
		this.kiNangTichLuyMoTa = kiNangTichLuyMoTa;
	}

	public String getDinhHuong() {
		return dinhHuong;
	}

	public void setDinhHuong(String dinhHuong) {
		this.dinhHuong = dinhHuong;
	}

	public int getDanhGiaTongThe() {
		return danhGiaTongThe;
	}

	public void setDanhGiaTongThe(int danhGiaTongThe) {
		this.danhGiaTongThe = danhGiaTongThe;
	}

	public TrangThaiDanhGia getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiDanhGia trangThai) {
		this.trangThai = trangThai;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

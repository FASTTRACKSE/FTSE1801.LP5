package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

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
@Table(name="ky_nang")
public class KyNang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_ky_nang", nullable= false)
	private int maKyNang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanVien hoSoNhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_loai_ky_nang", nullable = false)
	private LoaiKyNang loaiKyNang;
	
	@Column(name="ten_ky_nang", nullable=false)
	private String tenKyNang;
	
	@Column(name="danh_gia", nullable= false)
	private int danhGia;

	public int getMaKyNang() {
		return maKyNang;
	}

	public void setMaKyNang(int maKyNang) {
		this.maKyNang = maKyNang;
	}

	public HoSoNhanVien getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVien hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public LoaiKyNang getLoaiKyNang() {
		return loaiKyNang;
	}

	public void setLoaiKyNang(LoaiKyNang loaiKyNang) {
		this.loaiKyNang = loaiKyNang;
	}

	public String getTenKyNang() {
		return tenKyNang;
	}

	public void setTenKyNang(String tenKyNang) {
		this.tenKyNang = tenKyNang;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}
	
}

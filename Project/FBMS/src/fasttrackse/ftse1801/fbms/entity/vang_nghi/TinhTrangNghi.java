package fasttrackse.ftse1801.fbms.entity.vang_nghi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import fasttrackse.ftse1801.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "tinh_trang_nghi")
public class TinhTrangNghi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tinh_trang")
	private int idTinhTrang;
	
	@NotNull
	@Column(name = "ma_nhan_vien")
	private HoSoNhanVien maNhanVien;
	
	@NotNull
	@Column(name = "ma_loai_nghi")
	private LoaiNghiPhep maLoaiNghi;
	
	public LoaiNghiPhep getMaLoaiNghi() {
		return maLoaiNghi;
	}

	public void setMaLoaiNghi(LoaiNghiPhep maLoaiNghi) {
		this.maLoaiNghi = maLoaiNghi;
	}

	@Column(name = "ngay_da_nghi")
	private String ngayDaNghi;

	public int getIdTinhTrang() {
		return idTinhTrang;
	}

	public void setIdTinhTrang(int idTinhTrang) {
		this.idTinhTrang = idTinhTrang;
	}

	public HoSoNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getNgayDaNghi() {
		return ngayDaNghi;
	}

	public void setNgayDaNghi(String ngayDaNghi) {
		this.ngayDaNghi = ngayDaNghi;
	}
}

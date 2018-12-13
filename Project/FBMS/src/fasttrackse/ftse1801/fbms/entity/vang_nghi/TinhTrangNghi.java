package fasttrackse.ftse1801.fbms.entity.vang_nghi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

@Entity
@Table(name = "tinh_trang_nghi")
public class TinhTrangNghi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tinh_trang")
	private int idTinhTrang;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanSu idNhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_loai_nghi", nullable = false)
	private LoaiNghiPhep maLoaiNghi;

	@Column(name = "ngay_da_nghi")
	private int soNgayDaNghi;

	@Column(name = "ngay_nghi_con_lai")
	private int soNgayConLai;

	public int getIdTinhTrang() {
		return idTinhTrang;
	}

	public void setIdTinhTrang(int idTinhTrang) {
		this.idTinhTrang = idTinhTrang;
	}

	public LoaiNghiPhep getMaLoaiNghi() {
		return maLoaiNghi;
	}

	public void setMaLoaiNghi(LoaiNghiPhep maLoaiNghi) {
		this.maLoaiNghi = maLoaiNghi;
	}

	public int getNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public HoSoNhanSu getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(HoSoNhanSu idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public int getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(int soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

}
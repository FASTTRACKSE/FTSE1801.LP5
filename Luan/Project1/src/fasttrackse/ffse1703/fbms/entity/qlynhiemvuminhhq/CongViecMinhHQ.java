package fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq;




import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "cong_viec")
public class CongViecMinhHQ {
	
	@Id
	@Column(name = "ID")
	@NotNull
	private int ID;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongViec;
	
	@ManyToOne
	@JoinColumn(name = "ID_CV", nullable=false)
	@NotNull
	private LoaiCongViecMinhHQ maCongViec;
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;
	
	@Column(name = "tg_bat_dau")
	@NotNull
	private Date tgBatDau;
	
	@Column(name = "tg_ket_thuc")
	@NotNull
	private Date tgKetThuc;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", nullable=false)
	private HoSoNhanVien phanCong;
	
	@Column(name = "tg_du_kien")
	@NotEmpty
	private String tgDuKien;
	
	@ManyToOne
	@JoinColumn(name = "ID_TT", nullable=false)
	@NotNull
	private TrangThaiMinhHQ maTrangThai;
	
	@ManyToOne
	@JoinColumn(name = "ma_du_an", nullable=false)
	private DuAnMinhHQ duAn;
	
	@Column(name = "is_delete")
	@NotNull
	private int isDelete;
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	

	public LoaiCongViecMinhHQ getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(LoaiCongViecMinhHQ maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getTgBatDau() {
		return tgBatDau;
	}

	public void setTgBatDau(Date tgBatDau) {
		this.tgBatDau = tgBatDau;
	}

	public Date getTgKetThuc() {
		return tgKetThuc;
	}

	public void setTgKetThuc(Date tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}

	public HoSoNhanVien getPhanCong() {
		return phanCong;
	}

	public void setPhanCong(HoSoNhanVien phanCong) {
		this.phanCong = phanCong;
	}

	public String getTgDuKien() {
		return tgDuKien;
	}

	public void setTgDuKien(String tgDuKien) {
		this.tgDuKien = tgDuKien;
	}

	

	public TrangThaiMinhHQ getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThaiMinhHQ maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public DuAnMinhHQ getDuAn() {
		return duAn;
	}

	public void setDuAn(DuAnMinhHQ duAn) {
		this.duAn = duAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}

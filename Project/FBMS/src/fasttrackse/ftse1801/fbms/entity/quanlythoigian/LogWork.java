package fasttrackse.ftse1801.fbms.entity.quanlythoigian;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name = "quan_ly_thoi_gian")
public class LogWork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien")
	@NotNull
	private HoSoNhanSu nhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	@NotNull
	private PhongBan phongBan;

	@Column(name = "ma_du_an", nullable = false)
	private int duAn;

	@Column(name = "ma_vai_tro", nullable = false)
	private String vaiTroNV;

	@Column(name = "time", nullable = false)
	@NotEmpty
	private double time;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "job_description", nullable = false, length = 500)
	@NotEmpty
	private String moTaCongViec;

	@Column(name = "status", nullable = false, length = 1)
	@NotEmpty
	private int trangThai;

	@Column(name = "is_delete", nullable = false, length = 1)
	@NotEmpty
	private int isDelete;

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

	public int getDuAn() {
		return duAn;
	}

	public void setDuAn(int duAn) {
		this.duAn = duAn;
	}

	public String getVaiTroNV() {
		return vaiTroNV;
	}

	public void setVaiTroNV(String vaiTroNV) {
		this.vaiTroNV = vaiTroNV;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMoTaCongViec() {
		return moTaCongViec;
	}

	public void setMoTaCongViec(String moTaCongViec) {
		this.moTaCongViec = moTaCongViec;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}

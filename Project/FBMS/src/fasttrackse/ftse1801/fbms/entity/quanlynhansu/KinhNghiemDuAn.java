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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;

@Entity
@Table(name="kinh_nghiem_du_an")
public class KinhNghiemDuAn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_kinh_nghiem_du_an", nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanSu maNhanVien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_du_an", nullable = false)
	private DuAn maDuAn;
	
	@Column(name = "isdelete", nullable = false)
	private int isdelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanSu getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanSu maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public DuAn getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(DuAn maDuAn) {
		this.maDuAn = maDuAn;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	
}

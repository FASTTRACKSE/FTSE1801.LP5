package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ho_so_nhan_vien")
public class HoSoNhanVien implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nhan_vien")
	private int maNhanVien;

	@Column(name = "ho_dem")
	private String hoDem;
	
	private String ten;
	@Column(name = "ma_phong_ban")
	private String maPhongBan;

	@ManyToMany(mappedBy="nhiemVu",fetch = FetchType.EAGER,targetEntity=DuAn.class)
	private Set<DuAn> duAn;
	
	@ManyToMany(targetEntity = VaiTroThanhVien.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "nhiem_vu", joinColumns = {
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_vai_tro", referencedColumnName = "ma_vai_tro", nullable = true, updatable = false,insertable=true) })
	private Set<VaiTroThanhVien> vaiTro;

	public HoSoNhanVien() {
	}

	public Set<VaiTroThanhVien> getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(Set<VaiTroThanhVien> vaiTro) {
		this.vaiTro = vaiTro;
	}

	public int getMaNhanVien() {
		return this.maNhanVien;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getHoDem() {
		return this.hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	public Set<DuAn> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAn> duAn) {
		this.duAn = duAn;
	}


}

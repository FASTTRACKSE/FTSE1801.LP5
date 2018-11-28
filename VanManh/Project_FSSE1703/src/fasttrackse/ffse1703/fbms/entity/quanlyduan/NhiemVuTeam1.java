package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhiem_vu")
public class NhiemVuTeam1 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ma_du_an")
	private String maDuAn;
	@Id
	@Column(name="ma_nhan_vien")
	private int maNhanVien;
	@Id
	@Column(name="ma_vai_tro")
	private String maVaiTro;
	
	public NhiemVuTeam1() {
		super();
	}
	public NhiemVuTeam1(String maDuAn, int maNhanVien, String maVaiTro) {
		super();
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.maVaiTro = maVaiTro;
	}
	public String getMaDuAn() {
		return maDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}
	
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaVaiTro() {
		return maVaiTro;
	}
	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}
	
	
}
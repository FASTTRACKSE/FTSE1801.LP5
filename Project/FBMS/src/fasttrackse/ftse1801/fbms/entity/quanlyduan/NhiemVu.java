package fasttrackse.ftse1801.fbms.entity.quanlyduan;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;

@Entity
@Table(name = "nhiem_vu_du_an")
public class NhiemVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhiemVu;
	
	@ManyToOne
	@JoinColumn(name = "ma_du_an")
	private DuAn duAn;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	@NotNull
	private HoSoNhanSu hoSoNhanSu;
	
	@ManyToOne
	@JoinColumn(name = "ma_vai_tro")
	@NotNull
	private VaiTroThanhVien vaiTroThanhVien;
	
	@JoinColumn(name = "is_delete")
	private int isDelete;

	
	public int getMaNhiemVu() {
		return maNhiemVu;
	}

	public void setMaNhiemVu(int maNhiemVu) {
		this.maNhiemVu = maNhiemVu;
	}

	public DuAn getDuAn() {
		return duAn;
	}

	public void setDuAn(DuAn duAn) {
		this.duAn = duAn;
	}

	public HoSoNhanSu getHoSoNhanSu() {
		return hoSoNhanSu;
	}

	public void setHoSoNhanSu(HoSoNhanSu hoSoNhanSu) {
		this.hoSoNhanSu = hoSoNhanSu;
	}

	public VaiTroThanhVien getVaiTroThanhVien() {
		return vaiTroThanhVien;
	}

	public void setVaiTroThanhVien(VaiTroThanhVien vaiTroThanhVien) {
		this.vaiTroThanhVien = vaiTroThanhVien;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
=======
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="nhiem_vu")
public class NhiemVu implements Serializable{
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
	
	public NhiemVu() {
	
	}
	public NhiemVu(String maDuAn, int maNhanVien, String maVaiTro) {
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

>>>>>>> parent of fef500d... update
}

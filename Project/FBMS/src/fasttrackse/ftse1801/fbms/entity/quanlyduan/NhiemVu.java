package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;


@Entity
@Table(name = "nhiem_vu_du_an")
public class NhiemVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maNhiemVu", unique = true)
	private int maNhiemVu;

	@Column(name = "ma_du_an", nullable = false)
	@NotEmpty
	private String maDuAn;

	@Column(name = "ma_nhan_vien", nullable = false)
	@NotEmpty
	private String maNhanVien;

	@Column(name = "ma_vai_tro", nullable = false)
	@NotEmpty
	private String maVaiTro;
	
	@JoinColumn(name = "is_delete")
	private int isDelete;
	
	/*
	 * 
	 * Many To one
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private DuAn duAn;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private HoSoNhanSu hoSoNhanSu;

	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", referencedColumnName = "ma_vai_tro", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private VaiTroThanhVien vaiTroThanhVien;
	
	
	
	public NhiemVu() {
		super();
	}
	public NhiemVu(int maNhiemVu, @NotEmpty String maDuAn, @NotEmpty String maNhanVien, @NotEmpty String maVaiTro,
			int isDelete, @NotEmpty DuAn duAn, @NotEmpty HoSoNhanSu hoSoNhanSu,
			@NotEmpty VaiTroThanhVien vaiTroThanhVien) {
		super();
		this.maNhiemVu = maNhiemVu;
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.maVaiTro = maVaiTro;
		this.isDelete = isDelete;
		this.duAn = duAn;
		this.hoSoNhanSu = hoSoNhanSu;
		this.vaiTroThanhVien = vaiTroThanhVien;
	}
	
	
	public String getMaDuAn() {
		return maDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaVaiTro() {
		return maVaiTro;
	}
	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}
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
	

	
}

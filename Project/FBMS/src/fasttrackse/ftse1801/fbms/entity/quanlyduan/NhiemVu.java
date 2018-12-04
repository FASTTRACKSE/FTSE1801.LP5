package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


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
	private HoSoNhanVien hoSoNhanVien;
	@ManyToOne
	@JoinColumn(name = "ma_vai_tro")
	@NotNull
	private VaiTroThanhVien vaiTroThanhVien;
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
	public HoSoNhanVien getHoSoNhanVien() {
		return hoSoNhanVien;
	}
	public void setHoSoNhanVien(HoSoNhanVien hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
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

package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
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

/**
 * The persistent class for the thong_tin_bang_cap database table.
 * 
 */
@Entity
@Table(name = "thong_tin_bang_cap")
public class ThongTinBangCapTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	// bi-directional many-to-one association to HoSoNhanVien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanVienTT hoSoNhanVienTT;

	@Column(name = "ten_bang_cap", nullable = false, length = 250)
	@NotEmpty(message="Degrees can not be empty!")	
	private String tenBangCap;

	@Column(name = "loai_bang_cap", nullable = false, length = 20)
	@NotEmpty(message="You have not entered the type information by level!")	
	private String loaiBangCap;

	@Column(name = "don_vi_cap", nullable = false, length = 200)
	@NotEmpty(message="You have not entered level information!")	
	private String donViCap;

	@Column(name = "noi_cap", nullable = false, length = 200)
	@NotEmpty(message="You have not entered your information yet!")	
	private String noiCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap", nullable = false)
	@NotNull
	private Date ngayCap;

	@Column(name = "isdelete", nullable = false)
	private Integer isdelete;

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public ThongTinBangCapTT() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonViCap() {
		return this.donViCap;
	}

	public void setDonViCap(String donViCap) {
		this.donViCap = donViCap;
	}

	public String getLoaiBangCap() {
		return this.loaiBangCap;
	}

	public void setLoaiBangCap(String loaiBangCap) {
		this.loaiBangCap = loaiBangCap;
	}

	public Date getNgayCap() {
		return this.ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getTenBangCap() {
		return this.tenBangCap;
	}

	public void setTenBangCap(String tenBangCap) {
		this.tenBangCap = tenBangCap;
	}

	public HoSoNhanVienTT getHoSoNhanVienTT() {
		return hoSoNhanVienTT;
	}

	public void setHoSoNhanVienTT(HoSoNhanVienTT hoSoNhanVienTT) {
		this.hoSoNhanVienTT = hoSoNhanVienTT;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

}
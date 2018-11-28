package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "du_an")
public class DuAnEntityHieuLp {

	public DuAnEntityHieuLp() {
		super();

	}

	@Id
	@Column(name = "ma_du_an")
	@NotEmpty
	private int maDuan;

	@Column(name = "ten_du_an")
	@NotEmpty
	private String tenDuan;

	@Column(name = "ma_khach_hang")
	@NotEmpty
	private String maKhachhang;

	@Column(name = "mo_ta_du_an")
	@NotEmpty
	private String moTaduan;

	@Column(name = "ma_tinh_trang")
	@NotEmpty
	private String maTinhtrang;

	@Column(name = "ma_nghiep_vu")
	@NotEmpty
	private String maNghiepvu;

	@Column(name = "start_date")
	@NotNull
	private Date startDate;

	@Column(name = "end_date")
	@NotNull
	private String endDate;

	@Column(name = "is_delete")
	@NotEmpty
	private int isDelete;

	public int getMaDuan() {
		return maDuan;
	}

	public void setMaDuan(int maDuan) {
		this.maDuan = maDuan;
	}

	public String getTenDuan() {
		return tenDuan;
	}

	public void setTenDuan(String tenDuan) {
		this.tenDuan = tenDuan;
	}

	public String getMaKhachhang() {
		return maKhachhang;
	}

	public void setMaKhachhang(String maKhachhang) {
		this.maKhachhang = maKhachhang;
	}

	public String getMoTaduan() {
		return moTaduan;
	}

	public void setMoTaduan(String moTaduan) {
		this.moTaduan = moTaduan;
	}

	public String getMaTinhtrang() {
		return maTinhtrang;
	}

	public void setMaTinhtrang(String maTinhtrang) {
		this.maTinhtrang = maTinhtrang;
	}

	public String getMaNghiepvu() {
		return maNghiepvu;
	}

	public void setMaNghiepvu(String maNghiepvu) {
		this.maNghiepvu = maNghiepvu;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}

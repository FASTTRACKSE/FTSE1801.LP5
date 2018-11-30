package ftse1801.demo.spring.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tai_lieu")
public class TaiLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tai_lieu")
	private int taiLieu;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Ma_Danh_Muc", referencedColumnName = "Ma_Danh_Muc", nullable = false)
	private DanhMucTaiLieu danhMucTaiLieu;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_icon", referencedColumnName = "ma_icon", nullable = false)
	private IconTaiLieu iconTaiLieu;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "", referencedColumnName = "", nullable = false)
	private PhongBan phongBan;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", nullable = false)
	private TrangThaiTaiLieu trangThaiTaiLieu;

	
	@Column(name = "ma_tai_lieu")
	private String maTaiLieu;

	
	@Column(name = "ten_tai_lieu")
	private String tenTaiLieu;

	
	@Column(name = "mo_taTL")
	private String moTaTaiLieu;

	
	@Column(name = "Link")
	private String linkTaiLieu;

	
	@Column(name = "isDelete")
	private Integer isDelete;

	public int getTaiLieu() {
		return taiLieu;
	}

	public void setTaiLieu(int taiLieu) {
		this.taiLieu = taiLieu;
	}

	public DanhMucTaiLieu getDanhMucTaiLieu() {
		return danhMucTaiLieu;
	}

	public void setDanhMucTaiLieu(DanhMucTaiLieu danhMucTaiLieu) {
		this.danhMucTaiLieu = danhMucTaiLieu;
	}

	public IconTaiLieu getIconTaiLieu() {
		return iconTaiLieu;
	}

	public void setIconTaiLieu(IconTaiLieu iconTaiLieu) {
		this.iconTaiLieu = iconTaiLieu;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public TrangThaiTaiLieu getTrangThaiTaiLieu() {
		return trangThaiTaiLieu;
	}

	public void setTrangThaiTaiLieu(TrangThaiTaiLieu trangThaiTaiLieu) {
		this.trangThaiTaiLieu = trangThaiTaiLieu;
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getTenTaiLieu() {
		return tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}

	public String getMoTaTaiLieu() {
		return moTaTaiLieu;
	}

	public void setMoTaTaiLieu(String moTaTaiLieu) {
		this.moTaTaiLieu = moTaTaiLieu;
	}

	public String getLinkTaiLieu() {
		return linkTaiLieu;
	}

	public void setLinkTaiLieu(String linkTaiLieu) {
		this.linkTaiLieu = linkTaiLieu;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}

package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

@Entity
@Table(name = "du_an")
public class DuAn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_du_an")
	private int maDuAn;

	@Column(name = "ten_du_an")
	@NotEmpty(message = "Tên Dự án bắt buộc nhập")
	private String tenDuAn;

	@Column(name = "mo_ta_du_an")
	@NotEmpty(message = "Không được để trống")
	private String moTaDuAn;

	@Column(name = "is_delete")
	private int isDelete;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "thời gian Dự án bắt buộc nhập")
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "thời gian Dự án bắt buộc nhập")
	private Date endDate;
	
	// many-to-one
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Contact")
	private KhachHang khachHang;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "phong_du_an", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	@NotNull(message = "Không được để trống")
	private PhongBan phongDuAn;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Trạng thái")
	private TrangThai trangThai;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_nghiep_vu", referencedColumnName = "ma_nghiep_vu", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn nghiệp vụ")
	private Domain domain;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "pm", referencedColumnName = "ma_nhan_vien", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chon PM")
	private HoSoNhanSu pM;

	// many-to-many
	@ManyToMany(targetEntity = CongNghe.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cong_nghe_du_an", joinColumns = {
	@JoinColumn(name = "ma_cong_nghe") }, inverseJoinColumns = {
	@JoinColumn(name = "ma_du_an") })
	private Set<CongNghe> congNghe;
	
	@ManyToMany(targetEntity = Framework.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "framework_du_an", joinColumns = {
	@JoinColumn(name = "ma_framework") }, inverseJoinColumns = {
	@JoinColumn(name = "ma_du_an") })
	private Set<Framework> framework;
	
	@ManyToMany(targetEntity = Database.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "database_du_an", joinColumns = {
	@JoinColumn(name = "ma_database") }, inverseJoinColumns = {
	@JoinColumn(name = "ma_du_an") })
	private Set<Database> database;
	
	@ManyToMany(targetEntity = NgonNgu.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ngon_ngu_du_an", joinColumns = {
	@JoinColumn(name = "ma_ngon_ngu") }, inverseJoinColumns = {
	@JoinColumn(name = "ma_du_an") })
	private Set<NgonNgu> ngonNgu;
	
	@ManyToMany(targetEntity = Vendor.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "vendor_du_an", joinColumns = {
	@JoinColumn(name = "ma_vendor") }, inverseJoinColumns = {
	@JoinColumn(name = "ma_du_an") })
	private Set<Vendor> vendor;
	
	@OneToMany(mappedBy = "duAn")
	private Set<NhiemVu> nhiemVu;

	
	public int getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(int maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMoTaDuAn() {
		return moTaDuAn;
	}

	public void setMoTaDuAn(String moTaDuAn) {
		this.moTaDuAn = moTaDuAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public PhongBan getPhongDuAn() {
		return phongDuAn;
	}

	public void setPhongDuAn(PhongBan phongDuAn) {
		this.phongDuAn = phongDuAn;
	}

	public TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public HoSoNhanSu getpM() {
		return pM;
	}

	public void setpM(HoSoNhanSu pM) {
		this.pM = pM;
	}

	public Set<CongNghe> getCongNghe() {
		return congNghe;
	}

	public void setCongNghe(Set<CongNghe> congNghe) {
		this.congNghe = congNghe;
	}

	public Set<Framework> getFramework() {
		return framework;
	}

	public void setFramework(Set<Framework> framework) {
		this.framework = framework;
	}

	public Set<Database> getDatabase() {
		return database;
	}

	public void setDatabase(Set<Database> database) {
		this.database = database;
	}

	public Set<NgonNgu> getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(Set<NgonNgu> ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public Set<NhiemVu> getNhiemVu() {
		return nhiemVu;
	}

	public void setNhiemVu(Set<NhiemVu> nhiemVu) {
		this.nhiemVu = nhiemVu;
	}

}

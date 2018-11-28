package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Entity
@Table(name="du_an")
public class DuAnTeam1 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message="Không được để trống")
	@Column(name="ma_du_an")
	private String maDuAn;
	
	@Column(name="ten_du_an")
	@NotEmpty(message="Không được để trống")
	private String tenDuAn;
	
	@Column(name="mo_ta_du_an")
	@NotEmpty(message="Không được để trống")
	private String moTaDuAn;
	

	@Column(name="is_delete")
	private int isDelete;
	
	@Column (name="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message="Không được để trống")
	private Date startDate;
	
	@Column (name="end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="Không được để trống")
	private Date endDate;
	
	@ManyToMany(targetEntity = DatabaseTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "database_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_database", referencedColumnName = "ma_database", nullable = true, updatable = false,insertable=true) })
	private Set<DatabaseTeam1> database;

	@ManyToMany(targetEntity = TechnicalTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cong_nghe_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_cong_nghe", referencedColumnName = "ma_cong_nghe", nullable = true, updatable = false,insertable=true) })
	private Set<TechnicalTeam1> technical;
	
	@ManyToMany(targetEntity = FrameworkTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "framework_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_framework", referencedColumnName = "ma_framework", nullable = true, updatable = false,insertable=true) })
	private Set<FrameworkTeam1> framework;
	
	@ManyToMany(targetEntity = ProgramingLanguageTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ngon_ngu_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_ngon_ngu", referencedColumnName = "ma_ngon_ngu", nullable = true, updatable = false,insertable=true) })
	private Set<ProgramingLanguageTeam1> ngonNgu;


	@ManyToMany(targetEntity = VendorTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "doi_tac_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_doi_tac", referencedColumnName = "ma_doi_tac", nullable = true, updatable = false,insertable=true) })
	private Set<VendorTeam1> vendor;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ma_khach_hang",referencedColumnName="ma_khach_hang", insertable=true, updatable=true)
	@NotNull(message="Không được để trống")
	private KhachHangTeam1 khachHang;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ma_tinh_trang",referencedColumnName="ma_tinh_trang", insertable=true, updatable=true)
	@NotNull
	private TrangThaiTeam1 trangThai;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ma_nghiep_vu",referencedColumnName="ma_nghiep_vu", insertable=true, updatable=true)
	@NotNull(message="Không được để trống")
	private DomainTeam1 domain;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ma_phong_ban",referencedColumnName="ma_phong_ban", insertable=true, updatable=true)
	@NotNull(message="Không được để trống")
	private PhongBan phongBan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ma_nhan_vien",referencedColumnName="ma_nhan_vien", insertable=true, updatable=true)
	@NotNull(message="Không được để trống")
	private HoSoNhanVienTeam1 pM;
	
	@ManyToMany(targetEntity = HoSoNhanVienTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "nhiem_vu", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", nullable = true, updatable = false,insertable=true) })
	private Set<HoSoNhanVienTeam1> nhiemVu;
	
	public Set<HoSoNhanVienTeam1> getNhiemVu() {
		return nhiemVu;
	}

	public void setNhiemVu(Set<HoSoNhanVienTeam1> nhiemVu) {
		this.nhiemVu = nhiemVu;
	}

	public Set<ProgramingLanguageTeam1> getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(Set<ProgramingLanguageTeam1> ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public Set<TechnicalTeam1> getTechnical() {
		return technical;
	}

	public void setTechnical(Set<TechnicalTeam1> technical) {
		this.technical = technical;
	}

	public Set<FrameworkTeam1> getFramework() {
		return framework;
	}

	public HoSoNhanVienTeam1 getpM() {
		return pM;
	}

	public void setpM(HoSoNhanVienTeam1 pM) {
		this.pM = pM;
	}

	public void setFramework(Set<FrameworkTeam1> framework) {
		this.framework = framework;
	}

	public Set<VendorTeam1> getVendor() {
		return vendor;
	}

	public void setVendor(Set<VendorTeam1> vendor) {
		this.vendor = vendor;
	}

	public TrangThaiTeam1 getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiTeam1 trangThai) {
		this.trangThai = trangThai;
	}

	public DomainTeam1 getDomain() {
		return domain;
	}

	public void setDomain(DomainTeam1 domain) {
		this.domain = domain;
	}

	public KhachHangTeam1 getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangTeam1 khachHang) {
		this.khachHang = khachHang;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public Set<DatabaseTeam1> getDatabase() {
		return database;
	}

	public void setDatabase(Set<DatabaseTeam1> database) {
		this.database = database;
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

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return "DuAnTeam1 [maDuAn=" + maDuAn + ", tenDuAn=" + tenDuAn + ", moTaDuAn=" + moTaDuAn + ", isDelete="
				+ isDelete + ", startDate=" + startDate + ", endDate=" + endDate + ", database=" + database
				+ ", technical=" + technical + ", framework=" + framework + ", ngonNgu=" + ngonNgu + ", vendor="
				+ vendor + ", khachHang=" + khachHang + ", trangThai=" + trangThai + ", domain=" + domain
				+ ", phongBan=" + phongBan + ", pM=" + pM + ", nhiemVu=" + nhiemVu + "]";
	}

}

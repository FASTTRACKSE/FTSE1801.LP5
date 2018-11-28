package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UsersRoles;

@Entity
@Table(name = "qlda_project")
public class Projects implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_project")
	@NotEmpty(message="Mã Dự án bắt buộc nhập")
	@Size(min=6,max=10,message="Mã dự án 6 đến 10 kí tự")
	private String idProject;

	@Column(name = "name_project")
	@NotEmpty(message="Tên Dự án bắt buộc nhập")
	private String nameProject;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="thời gian Dự án bắt buộc nhập")
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	@NotNull(message="thời gian Dự án bắt buộc nhập")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;

	@Column(name = "project_details")
	private String detail;
	
	
	// bi-directional many-to-one association to KhachHang
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = true, updatable = true)
	@NotNull(message="Bạn chưa chọn khách hàng")
	private KhachHang khachHang;
	
	// bi-directional many-to-one association to PhongBan
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_project_room", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	@NotNull(message="Bạn chưa chọn phòng dự án")
	private PhongBan roomProject;
	
	// bi-directional many-to-one association to Status
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_status", referencedColumnName = "id_status", insertable = true, updatable = true)
	@NotNull(message="Bạn chưa chọn Trạng thái")
	private StatusProject status;

	// bi-directional many-to-one association to Doamin
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_domain", referencedColumnName = "id_domain", insertable = true, updatable = true)
	@NotNull(message="Bạn chưa chọn nghiệp vụ")
	private Domain domain;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_pm", referencedColumnName = "MaNv", insertable = true, updatable = true)
	@NotNull(message="Bạn chưa PM")
	private HoSoNhanVienPikalong pm;
	
	// bi-directional many-to-many association to Technical
	@ManyToMany(targetEntity = Technical.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "qlda_technical_project", joinColumns = {
	@JoinColumn(name = "id_technical") }, inverseJoinColumns = {
	@JoinColumn(name = "id_project") })
	private Set<Technical> technical;

	// bi-directional many-to-many association to Database
	@ManyToMany(targetEntity = Database.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "qlda_database_project", joinColumns = {
	@JoinColumn(name = "id_database") }, inverseJoinColumns = { 
	@JoinColumn(name = "id_project") })
	private Set<Database> database;

	// bi-directional many-to-many association to Framework
	@ManyToMany(targetEntity = Framework.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "qlda_framework_project", joinColumns = {
	@JoinColumn(name = "id_framework") }, inverseJoinColumns = {
	@JoinColumn(name = "id_project") })
	private Set<Framework> framework;
	
	// bi-directional many-to-many association to Language
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "qlda_prolanguage_project", joinColumns = {
	@JoinColumn(name = "id_prolanguage") }, inverseJoinColumns = {
	@JoinColumn(name = "id_project") })
	private Set<Language> language;

	// bi-directional many-to-many association to Vendor
	@ManyToMany(targetEntity = Vendor.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "qlda_vendor_project", joinColumns = { 
	@JoinColumn(name = "id_vendor") }, inverseJoinColumns = {
	@JoinColumn(name = "id_project") })
	private Set<Vendor> vendor;
	
	@OneToMany(mappedBy = "projects")
	private Set<Nhiemvu> nhiemVu;
	
	@Column(name = "isdelete")
	private int isDelete;
	
	

	public Set<Nhiemvu> getNhiemVu() {
		return nhiemVu;
	}



	public void setNhiemVu(Set<Nhiemvu> nhiemVu) {
		this.nhiemVu = nhiemVu;
	}



	public String getIdProject() {
		return idProject;
	}

	

	public HoSoNhanVienPikalong getPm() {
		return pm;
	}

	public void setPm(HoSoNhanVienPikalong pm) {
		this.pm = pm;
	}



	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public PhongBan getRoomProject() {
		return roomProject;
	}

	public void setRoomProject(PhongBan roomProject) {
		this.roomProject = roomProject;
	}

	public StatusProject getStatus() {
		return status;
	}

	public void setStatus(StatusProject status) {
		this.status = status;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Set<Technical> getTechnical() {
		return technical;
	}

	public void setTechnical(Set<Technical> technical) {
		this.technical = technical;
	}

	public Set<Database> getDatabase() {
		return database;
	}

	public void setDatabase(Set<Database> database) {
		this.database = database;
	}

	public Set<Framework> getFramework() {
		return framework;
	}

	public void setFramework(Set<Framework> framework) {
		this.framework = framework;
	}

	public Set<Language> getLanguage() {
		return language;
	}

	public void setLanguage(Set<Language> language) {
		this.language = language;
	}

	public Set<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}

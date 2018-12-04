package fasttrackse.ftse1801.fbms.entity.quanlyduan;

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


	@Entity
	@Table(name="du_an")
	public class DuAn implements Serializable {
		
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
		
		@ManyToMany(targetEntity = Database.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "database_du_an", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_database", referencedColumnName = "ma_database", nullable = true, updatable = false,insertable=true) })
		private Set<Database> database;

		@ManyToMany(targetEntity = CongNghe.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "cong_nghe_du_an", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_cong_nghe", referencedColumnName = "ma_cong_nghe", nullable = true, updatable = false,insertable=true) })
		private Set<CongNghe> congNghe;
		
		@ManyToMany(targetEntity = Framework.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "framework_du_an", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_framework", referencedColumnName = "ma_framework", nullable = true, updatable = false,insertable=true) })
		private Set<Framework> framework;
		
		@ManyToMany(targetEntity = NgonNgu.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "ngon_ngu_du_an", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_ngon_ngu", referencedColumnName = "ma_ngon_ngu", nullable = true, updatable = false,insertable=true) })
		private Set<NgonNgu> ngonNgu;


		@ManyToMany(targetEntity = Contact.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "contact_du_an", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_contact", referencedColumnName = "ma_contact", nullable = true, updatable = false,insertable=true) })
		private Set<Contact> contact;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="ma_tinh_trang",referencedColumnName="ma_tinh_trang", insertable=true, updatable=true)
		@NotNull
		private TrangThai trangThai;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="ma_nghiep_vu",referencedColumnName="ma_nghiep_vu", insertable=true, updatable=true)
		@NotNull(message="Không được để trống")
		private Domain domain;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="ma_phong_ban",referencedColumnName="ma_phong_ban", insertable=true, updatable=true)
		@NotNull(message="Không được để trống")
		private PhongBan phongBan;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="ma_nhan_vien",referencedColumnName="ma_nhan_vien", insertable=true, updatable=true)
		@NotNull(message="Không được để trống")
		private HoSoNhanVien pM;
		
		@ManyToMany(targetEntity = HoSoNhanVien.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name = "nhiem_vu", joinColumns = {
		@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
		@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", nullable = true, updatable = false,insertable=true) })
		private Set<HoSoNhanVien> nhiemVu;
		
		public Set<HoSoNhanVien> getNhiemVu() {
			return nhiemVu;
		}

		public void setNhiemVu(Set<HoSoNhanVien> nhiemVu) {
			this.nhiemVu = nhiemVu;
		}

		public Set<NgonNgu> getNgonNgu() {
			return ngonNgu;
		}

		public void setNgonNgu(Set<NgonNgu> ngonNgu) {
			this.ngonNgu = ngonNgu;
		}
		public Set<CongNghe> getCongNghe() {
			return congNghe;
		}

		public void setcongNghe(Set<CongNghe> congNghe) {
			this.congNghe = congNghe;
		}

		public Set<Framework> getFramework() {
			return framework;
		}

		public HoSoNhanVien getpM() {
			return pM;
		}

		public void setpM(HoSoNhanVien pM) {
			this.pM = pM;
		}

		public void setFramework(Set<Framework> framework) {
			this.framework = framework;
		}

		public Set<Contact> getContact() {
			return contact;
		}

		public void setVendor(Set<Contact> contact) {
			this.contact = contact;
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

		public String getMaDuAn() {
			return maDuAn;
		}

		public void setMaDuAn(String maDuAn) {
			this.maDuAn = maDuAn;
		}

		public Set<Database> getDatabase() {
			return database;
		}

		public void setDatabase(Set<Database> database) {
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
			return "DuAn [maDuAn=" + maDuAn + ", tenDuAn=" + tenDuAn + ", moTaDuAn=" + moTaDuAn + ", isDelete="
					+ isDelete + ", startDate=" + startDate + ", endDate=" + endDate + ", database=" + database
					+ ", congNghe=" + congNghe + ", framework=" + framework + ", ngonNgu=" + ngonNgu + ", vendor="
					+ contact + ", khachHang=" + contact + ", trangThai=" + trangThai + ", domain=" + domain
					+ ", phongBan=" + phongBan + ", pM=" + pM + ", nhiemVu=" + nhiemVu + "]";
		}

}

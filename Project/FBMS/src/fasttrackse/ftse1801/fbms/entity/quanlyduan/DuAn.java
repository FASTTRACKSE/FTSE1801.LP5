package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_database", referencedColumnName = "ma_database", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Database")
	private Database database;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_cong_nghe", referencedColumnName = "ma_cong_nghe", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Công nghệ")
	private CongNghe congNghe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_framework", referencedColumnName = "ma_framework", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Framework")
	private Framework framework;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_ngon_ngu", referencedColumnName = "ma_ngon_ngu", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Ngôn Ngữ")
	private NgonNgu ngonNgu;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_contact", referencedColumnName = "ma_contact", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Khách hàng")
	private Contact contact;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn Trạng thái")
	private TrangThai trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nghiep_vu", referencedColumnName = "ma_nghiep_vu", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chọn nghiệp vụ")
	private Domain domain;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	@NotNull(message = "Không được để trống")
	private PhongBan phongBan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_pm", referencedColumnName = "ma_nhan_vien", insertable = true, updatable = true)
	@NotNull(message = "Bạn chưa chon PM")
	private HoSoNhanVien pM;

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

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public CongNghe getCongNghe() {
		return congNghe;
	}

	public void setCongNghe(CongNghe congNghe) {
		this.congNghe = congNghe;
	}

	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		this.framework = framework;
	}

	public NgonNgu getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(NgonNgu ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
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

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public HoSoNhanVien getpM() {
		return pM;
	}

	public void setpM(HoSoNhanVien pM) {
		this.pM = pM;
	}

	public Set<NhiemVu> getNhiemVu() {
		return nhiemVu;
	}

	public void setNhiemVu(Set<NhiemVu> nhiemVu) {
		this.nhiemVu = nhiemVu;
	}

	@Override
	public String toString() {
		return "DuAn [maDuAn=" + maDuAn + ", tenDuAn=" + tenDuAn + ", moTaDuAn=" + moTaDuAn + ", isDelete=" + isDelete
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", database=" + database + ", congNghe="
				+ congNghe + ", framework=" + framework + ", ngonNgu=" + ngonNgu + ", vendor=" + contact
				+ ", khachHang=" + contact + ", trangThai=" + trangThai + ", domain=" + domain + ", phongBan="
				+ phongBan + ", pM=" + pM + ", nhiemVu=" + nhiemVu + "]";
	}

}

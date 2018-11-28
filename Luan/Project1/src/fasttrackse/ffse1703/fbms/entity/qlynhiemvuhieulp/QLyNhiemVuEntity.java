package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quan_ly_nhiem_vu")
public class QLyNhiemVuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private int ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_du_an", nullable = false)
	@NotNull
	private DuAnEntityHieuLp duAn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_loai_cong_viec", nullable = false)
	private LoaicongviecEntity idLoaiCongviec;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongviec;

	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;

	@Column(name = "tg_bat_dau")
	@NotNull
	private Date tgBatdau;

	@Column(name = "tg_ket_thuc")
	@NotNull
	private Date tgKetthuc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private HoSoNhanVienHLP nhanVien;

	@Column(name = "tg_du_kien_hoan_thanh")
	@NotEmpty
	private String tgDukienhoanthanh;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_loai_trang_thai", nullable = false)
	private LoaitrangthaiEntity idLoaiTrangthai;

	@Column(name = "is_delete")
	private int isDelete;

	public QLyNhiemVuEntity() {
		super();

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public DuAnEntityHieuLp getDuAn() {
		return duAn;
	}

	public void setDuAn(DuAnEntityHieuLp duAn) {
		this.duAn = duAn;
	}

	public String getTenCongviec() {
		return tenCongviec;
	}

	public void setTenCongviec(String tenCongviec) {
		this.tenCongviec = tenCongviec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getTgBatdau() {
		return tgBatdau;
	}

	public void setTgBatdau(Date tgBatdau) {
		this.tgBatdau = tgBatdau;
	}

	public Date getTgKetthuc() {
		return tgKetthuc;
	}

	public void setTgKetthuc(Date tgKetthuc) {
		this.tgKetthuc = tgKetthuc;
	}

	public String getTgDukienhoanthanh() {
		return tgDukienhoanthanh;
	}

	public void setTgDukienhoanthanh(String tgDukienhoanthanh) {
		this.tgDukienhoanthanh = tgDukienhoanthanh;
	}

	public LoaitrangthaiEntity getLoaiTrangthai() {
		return idLoaiTrangthai;
	}

	public void setLoaiTrangthai(LoaitrangthaiEntity loaiTrangthai) {
		this.idLoaiTrangthai = loaiTrangthai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public LoaicongviecEntity getIdLoaiCongviec() {
		return idLoaiCongviec;
	}

	public void setIdLoaiCongviec(LoaicongviecEntity idLoaiCongviec) {
		this.idLoaiCongviec = idLoaiCongviec;
	}

	public LoaitrangthaiEntity getIdLoaiTrangthai() {
		return idLoaiTrangthai;
	}

	public void setIdLoaiTrangthai(LoaitrangthaiEntity idLoaiTrangthai) {
		this.idLoaiTrangthai = idLoaiTrangthai;
	}

	public HoSoNhanVienHLP getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(HoSoNhanVienHLP nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "QLyNhiemVuEntity [ID=" + ID + ", duAn=" + duAn + ", loaiCongviec=" + idLoaiCongviec + ", tenCongviec="
				+ tenCongviec + ", moTa=" + moTa + ", tgBatdau=" + tgBatdau + ", tgKetthuc=" + tgKetthuc + ", nhanVien="
				+ nhanVien + ", tgDukienhoanthanh=" + tgDukienhoanthanh + ", loaiTrangthai=" + idLoaiTrangthai
				+ ", isDelete=" + isDelete + "]";
	}

}

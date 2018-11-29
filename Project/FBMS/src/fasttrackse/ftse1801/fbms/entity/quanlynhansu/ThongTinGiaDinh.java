package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thong_tin_gia_dinh")
public class ThongTinGiaDinh {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanVien hoSoNhanVien;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "que_quan")
	private String queQuan;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "nam_sinh")
	private Date namSinh;

	@Column(name = "gioi_tinh")
	private String gioiTinh;

	@Column(name = "so_dien_thoai")
	private int soDienThoai;

	@Column(name = "quan_he")
	private String quanHe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanVien getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVien hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

}

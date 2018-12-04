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
	@Column(name = "ma_thong_tin_gia_dinh")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanSu hoSoNhanVien;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "que_quan")
	private String queQuan;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh")
	private Date namSinh;

	@Column(name = "gioi_tinh")
	private int gioiTinh;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "quan_he")
	private String quanHe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanSu getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanSu hoSoNhanVien) {
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

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

}

package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thong_tin_gia_dinh")
public class ThongTinGiaDinhTT {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to HoSoNhanVien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanVienTT hoSoNhanVienTT;

	@Column(name = "ten")
	@NotEmpty(message = "Name and surname must not be blank!")
	private String hoTen;

	@Column(name = "que_quan")
	@NotEmpty(message = "Please enter your country of residence!")
	private String queQuan;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh", nullable = false)
	@NotNull
	private Date namSinh;

	@Column(name = "gioi_tinh", nullable = false)
	@NotNull
	private Integer gioiTinh;

	@Column(name = "so_dien_thoai")
	@Size(min = 9, max = 12, message = "You entered the wrong number format!")
	@NotEmpty(message = "Please enter your phone number")
	private String soDienThoai;

	@Column(name = "quan_he")
	@NotEmpty(message = "Please enter the contact information!")
	private String quanHe;
	
	@Column(name = "isdelete", nullable = false)
	private Integer isdelete;

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanVienTT getHoSoNhanVienTT() {
		return hoSoNhanVienTT;
	}

	public void setHoSoNhanVienTT(HoSoNhanVienTT hoSoNhanVienTT) {
		this.hoSoNhanVienTT = hoSoNhanVienTT;
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

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
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

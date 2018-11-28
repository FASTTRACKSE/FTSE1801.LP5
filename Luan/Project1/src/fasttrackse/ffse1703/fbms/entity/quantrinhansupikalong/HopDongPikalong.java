package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="thongtinhopdong")
public class HopDongPikalong {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaHopDong")
	private int maHopDong;

	@ManyToOne
	@JoinColumn(name="MaNv")
	private HoSoNhanVienPikalong hoSoNhanVienPikalong;
	
	@NotNull(message = "Vui lòng chọn tên hợp đồng!!!")
	@ManyToOne
	@JoinColumn(name="MaLoaiHopDong")
	private LoaiHopDongPikalong loaiHopDongPikalong;
	
	@NotNull(message = "Vui lòng chọn Ngày-Tháng-Năm!!!")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayKiKet")
	private Date ngayKiKet;
	
	@NotNull(message = "Vui lòng chọn Ngày-Tháng-Năm!!!")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayKetThuc")
	private Date ngayKetThuc;
	
	@NotNull(message = "Vui lòng chọn ngày nghỉ!!!")
	@Column(name = "SoNgayNghiTrongNam")
	private int soNgayNghiTrongNam;
	
	@NotEmpty(message = "Vui lòng chọn mức lương!!!")
	@Column(name = "LuongThang13")
	private String luongThang13;
	
	@Column(name = "TrangThai")
	@NotNull
	private int trangThai;
	
	
	public HopDongPikalong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HopDongPikalong(int maHopDong, Date ngayKiKet, Date ngayKetThuc,
			int soNgayNghiTrongNam, String luongThang13, int trangThai) {
		super();
		this.maHopDong = maHopDong;
		this.ngayKiKet = ngayKiKet;
		this.ngayKetThuc = ngayKetThuc;
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
		this.luongThang13 = luongThang13;
		this.trangThai = trangThai;
	}

	
	
	public LoaiHopDongPikalong getLoaiHopDongPikalong() {
		return loaiHopDongPikalong;
	}

	public void setLoaiHopDongPikalong(LoaiHopDongPikalong loaiHopDongPikalong) {
		this.loaiHopDongPikalong = loaiHopDongPikalong;
	}

	public int getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}
	
	public Date getNgayKiKet() {
		return ngayKiKet;
	}

	public void setNgayKiKet(Date ngayKiKet) {
		this.ngayKiKet = ngayKiKet;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgayNghiTrongNam() {
		return soNgayNghiTrongNam;
	}
	public void setSoNgayNghiTrongNam(int soNgayNghiTrongNam) {
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
	}
	public String getLuongThang13() {
		return luongThang13;
	}
	public void setLuongThang13(String luongThang13) {
		this.luongThang13 = luongThang13;
	}
	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public HoSoNhanVienPikalong getHoSoNhanVienPikalong() {
		return hoSoNhanVienPikalong;
	}

	public void setHoSoNhanVienPikalong(HoSoNhanVienPikalong hoSoNhanVienPikalong) {
		this.hoSoNhanVienPikalong = hoSoNhanVienPikalong;
	}

	@Override
	public String toString() {
		return "HopDongPikalong [maHopDong=" + maHopDong + ", hoSoNhanVienPikalong=" + hoSoNhanVienPikalong
				+ ", loaiHopDongPikalong=" + loaiHopDongPikalong + ", ngayKiKet=" + ngayKiKet + ", ngayKetThuc="
				+ ngayKetThuc + ", soNgayNghiTrongNam=" + soNgayNghiTrongNam + ", luongThang13=" + luongThang13
				+ ", trangThai=" + trangThai + "]";
	}
	
}
	


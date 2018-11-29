package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ThongTinGiaDinh")
public class GiaDinhPikalong {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "QuanHe")
	@NotEmpty(message="Quan Hệ Không được để trống !")
	private String quanHe;
	
	@Column(name = "HoTen")
	@NotEmpty(message="Họ Tên Không được để trống !")
	private String hoTen;
	
	@Column(name = "QueQuan")
	@NotEmpty(message="Quê Quán Không được để trống !")
	private String queQuan;
	
	@Column(name = "NoiOHienNay")
	@NotEmpty(message="Nơi ở hiện nay Không được để trống !")
	private String noiOHienNay;
	
	@Column(name = "NgheNghiep")
	@NotEmpty(message="Nghề Nghiệp Không được để trống !")
	private String ngheNghiep;
	
	@Column(name = "SDT")
	@Size(min = 9, max= 12, message = "Số Điện Thoại sai định dạng !")
	@NotEmpty(message="SDT Không được để trống !")
	private String sdt;
	
	@Column(name = "MaNv")
	@NotEmpty(message="Mã Nhân Viên Không được để trống !")
	private String maNV;
	
	@Column(name = "IsActive")
	private int isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
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

	public String getNoiOHienNay() {
		return noiOHienNay;
	}

	public void setNoiOHienNay(String noiOHienNay) {
		this.noiOHienNay = noiOHienNay;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
}

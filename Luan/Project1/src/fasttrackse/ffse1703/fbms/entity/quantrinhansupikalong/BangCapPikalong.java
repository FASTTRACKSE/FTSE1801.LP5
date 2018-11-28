package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ThongTinBangCap")
public class BangCapPikalong {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ChuyenNganh")
	@NotEmpty(message="Chuyên Ngành Không được để trống !")	
	private String chuyenNganh;
	
	@Column(name = "XepLoai")
	@NotEmpty(message="Xếp Loại Không được để trống !")
	private String xepLoai;
	
	@Column(name = "NoiCap")
	@NotEmpty(message="Nơi Cấp Không được để trống !")
	private String noiCap;
	
	
	@Column(name = "NgayCap")
	@NotEmpty(message="Ngày Cấp Không được để trống !")
	private String ngayCap;
	
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


	public String getChuyenNganh() {
		return chuyenNganh;
	}


	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}


	public String getXepLoai() {
		return xepLoai;
	}


	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}


	public String getNoiCap() {
		return noiCap;
	}


	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}


	public String getNgayCap() {
		return ngayCap;
	}


	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
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

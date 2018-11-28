package ftse1801.project.entity.quan_ly_nhan_su;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="phong_ban")
public class PhongBan {
	@Id
	@Column(name="ma_phong_ban")
	private String maPhongBan;

	@Column(name="ten_phong_ban")
	private String tenPhongBan;

	@OneToMany(mappedBy = "phongBan")
	private List<HoSoNhanVien> hoSoNhanViens;

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<HoSoNhanVien> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVien> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}
	
	
	
}

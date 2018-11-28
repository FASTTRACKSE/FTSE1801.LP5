package ftse1801.project.entity.quan_ly_nhan_su;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chuc_danh")
public class ChucDanh {
	@Id
	@Column(name = "ma_chuc_danh")
	private String maChucDanh;

	@Column(name = "ten_chuc_danh")
	private String tenChucDanh;
	
	@OneToMany(mappedBy = "chucDanh")
	private List<HoSoNhanVien> hoSoNhanViens;

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public String getTenChucDanh() {
		return tenChucDanh;
	}

	public void setTenChucDanh(String tenChucDanh) {
		this.tenChucDanh = tenChucDanh;
	}

	public List<HoSoNhanVien> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVien> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}
	
	
}

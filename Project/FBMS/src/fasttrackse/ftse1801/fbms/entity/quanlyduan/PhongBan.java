package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="phong_ban")
public class PhongBan {
	@Id
	@NotEmpty
	@Column(name = "ma_phong_ban")
	private String maPhongBan;
	
	@NotEmpty
	@Column(name = "ten_phong_ban")
	private String tenPhongBan;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "phongBan",cascade=CascadeType.MERGE)
	private Set<DuAn> duAn = new HashSet<DuAn>(0);


	public Set<DuAn> getDuAn() {
		return duAn;
	}


	public void setDuAn(Set<DuAn> duAn) {
		this.duAn = duAn;
	}


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
}

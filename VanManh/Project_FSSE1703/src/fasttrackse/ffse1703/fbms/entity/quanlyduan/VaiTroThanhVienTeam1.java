package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "vai_tro_thanh_vien")
public class VaiTroThanhVienTeam1 {
	@Id
	@NotEmpty(message="Mã không được để trống !")
	@Column(name = "ma_vai_tro")
	 String mavt;
	
	@Column(name = "ten_vai_tro")
	@NotEmpty(message="Tên không được để trống !")
	 String tenvt;
	
	@Column(name = "is_delete")
	 int isDelete;

	
	
	public String getMavt() {
		return mavt;
	}

	public void setMavt(String mavt) {
		this.mavt = mavt;
	}

	public String getTenvt() {
		return tenvt;
	}

	public void setTenvt(String tenvt) {
		this.tenvt = tenvt;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}

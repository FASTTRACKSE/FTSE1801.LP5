package fasttrackse.ftse1801.fbms.entity.quanlyduan;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ngon_ngu")
public class NgonNgu {
	@Id
	@NotEmpty(message="Mã ngôn ngữ không được rỗng!")
	@Column(name = "ma_ngon_ngu")
	 String maNgonNgu;
	
	@Column(name = "ten_ngon_ngu")
	@NotEmpty(message="Tên ngôn ngữ không được rỗng!")
	 String tenNgonNgu;
	
	
	@Column(name = "is_delete")
	 int isDelete;

	

	public String getMaNgonNgu() {
		return maNgonNgu;
	}

	public void setMaNgonNgu(String maNgonNgu) {
		this.maNgonNgu = maNgonNgu;
	}

	public String getTenNgonNgu() {
		return tenNgonNgu;
	}

	public void setTenNgonNgu(String tenNgonNgu) {
		this.tenNgonNgu = tenNgonNgu;
	}


	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}

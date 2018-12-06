package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "nghiep_vu")
public class Domain {

	@Id
	@NotEmpty(message = "Mã Nghiệp vụ không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã nghiệp vụ từ 5 đến 10 kí tự")
	@Column(name = "ma_nghiep_vu")
	private String maDomain;

	@NotEmpty(message = "Tên Nghiệp vụ không được để trống!!")
	@Size(min = 5, message = "Tên nghiệp vụ ít nhất 6 kí tự")
	@Column(name = "ten_nghiep_vu")
	private String tenDomain;

	@Column(name = "is_delete")
	private int isDelete;

	public String getMaDomain() {
		return maDomain;
	}

	public void setMaDomain(String maDomain) {
		this.maDomain = maDomain;
	}

	public String getTenDomain() {
		return tenDomain;
	}

	public void setTenDomain(String tenDomain) {
		this.tenDomain = tenDomain;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
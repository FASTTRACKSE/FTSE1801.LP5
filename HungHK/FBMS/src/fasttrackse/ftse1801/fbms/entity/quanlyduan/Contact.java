package fasttrackse.ftse1801.fbms.entity.quanlyduan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "ma_contact")
	@NotEmpty(message = "Mã khách hàng không được để rỗng !!!")
	private String makh;
	
	@Column(name = "ten_contact")
	@NotEmpty(message = "Tên khách hàng không được để rỗng !!!")
	private String tenkh;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "Địa chỉ không được để rỗng !!!")
	private String diachi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty(message = "Số điện thoại không được để rỗng !!!")
	private String sdt;
	
	@Column(name = "email")
	@NotEmpty(message = "Email không được để rỗng !!!")
	private String email;
	
	@Column(name = "is_delete")
	private int is_delete;

	
	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	
	

}

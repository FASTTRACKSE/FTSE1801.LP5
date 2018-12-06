package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="database_list")
public class Database {
	@Id
	@NotEmpty(message = "Mã Database không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã Database từ 5 đến 10 kí tự")
	@Column(name = "ma_database")
	private String maDatabase;
	
	@NotEmpty(message = "Mã database không được để trống!!")
	@Column(name = "ten_database")
	private String tenDatabase;
	@Column(name = "is_delete")
	private int isDelete;

	public String getMaDatabase() {
		return maDatabase;
	}

	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}

	public String getTenDatabase() {
		return tenDatabase;
	}

	public void setTenDatabase(String tenDatabase) {
		this.tenDatabase = tenDatabase;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}

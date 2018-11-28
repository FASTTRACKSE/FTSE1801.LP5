package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="qlda_database")
public class Database {
	@Id
	@NotEmpty(message = "Mã Database không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã Database từ 5 đến 10 kí tự")
	@Column(name = "id_database")
	private String idDatabase;
	
	@NotEmpty(message = "Mã database không được để trống!!")
	@Column(name = "name_database")
	private String nameDatabase;
	
	private int status;

	public String getIdDatabase() {
		return idDatabase;
	}

	public void setIdDatabase(String idDatabase) {
		this.idDatabase = idDatabase;
	}

	public String getNameDatabase() {
		return nameDatabase;
	}

	public void setNameDatabase(String nameDatabase) {
		this.nameDatabase = nameDatabase;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}

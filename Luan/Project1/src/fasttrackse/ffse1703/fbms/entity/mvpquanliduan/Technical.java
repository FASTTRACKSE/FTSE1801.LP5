package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name= "qlda_technical")
public class Technical {
	@Id
	@NotEmpty(message = "Mã Kĩ thuật không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã Kĩ thuật từ 5 đến 10 kí tự")
	@Column(name = "id_technical")
	private String idTechnical;
	
	@NotEmpty(message = "Tên Kĩ thuật không được để trống")
	@Size(min = 5, message = "Tên Kĩ thuật ít nhất 5 kí tự")
	@Column(name = "name_technical")
	private String nameTechnical;

	private int status;
	
	public String getIdTechnical() {
		return idTechnical;
	}

	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}

	public String getNameTechnical() {
		return nameTechnical;
	}

	public void setNameTechnical(String nameTechnical) {
		this.nameTechnical = nameTechnical;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
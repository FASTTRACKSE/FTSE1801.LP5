package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="qlda_status")
public class StatusProject {
	@Id
	@Column(name = "id_status")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStatus;
	
	@NotEmpty
	@Column(name="status")
	private String nameStatus;
	
	@NotEmpty
	private String color;
	
	@Column(name="isdelete")
	private int status;



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

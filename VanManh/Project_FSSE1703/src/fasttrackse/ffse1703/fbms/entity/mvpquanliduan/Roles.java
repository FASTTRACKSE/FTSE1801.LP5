package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="qlda_role")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_role")
	private int idRoles;
	
	@NotEmpty(message="Nhập tên vai trò")
	@Column(name="role")
	private String nameRoles;
	
	private int status;

	public int getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}

	public String getNameRoles() {
		return nameRoles;
	}

	public void setNameRoles(String nameRoles) {
		this.nameRoles = nameRoles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
}

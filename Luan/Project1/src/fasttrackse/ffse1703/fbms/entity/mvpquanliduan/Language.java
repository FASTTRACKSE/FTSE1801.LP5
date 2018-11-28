package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "qlda_program_language")
public class Language {
	@Id
	@Column(name = "id_program_language")
	@NotEmpty(message = "Mã không được để trống")
	private String idLanguage;
	@NotEmpty
	@Column(name = "name_language")	
	private String nameLanguage;
	
	private int status;

	public String getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(String idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getNameLanguage() {
		return nameLanguage;
	}
	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
}

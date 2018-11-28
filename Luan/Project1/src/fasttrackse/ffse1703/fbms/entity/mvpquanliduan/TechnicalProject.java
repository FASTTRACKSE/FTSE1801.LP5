package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qlda_technical_project")
public class TechnicalProject {
	@Id
	@Column(name = "id_technical")
	private String idTechnical;
	

	@Column(name = "id_project")
	private String idProject;

	public String getIdTechnical() {
		return idTechnical;
	}

	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}

	public String getIdProject() {
		return idProject;
	}

	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}
}

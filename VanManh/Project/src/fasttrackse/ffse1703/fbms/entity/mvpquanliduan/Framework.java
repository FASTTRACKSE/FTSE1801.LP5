package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "qlda_framework")
public class Framework {
	@Id
	@Column(name = "id_framework", unique = true, nullable = false)
	private String idFrame;
	@NotEmpty
	@Column(name = "name_framework", unique = true, nullable = false)
	private String nameFramework;

	private int status;
	
	@ManyToMany(targetEntity = Projects.class, mappedBy = "framework", fetch = FetchType.EAGER)
	private List<Projects> project;

	public List<Projects> getProject() {
		return project;
	}

	public void setProject(List<Projects> project) {
		this.project = project;
	}

	public String getIdFrame() {
		return idFrame;
	}

	public void setIdFrame(String idFrame) {
		this.idFrame = idFrame;
	}

	public String getNameFramework() {
		return nameFramework;
	}

	public void setNameFramework(String nameFramework) {
		this.nameFramework = nameFramework;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Framework [idFrame=" + idFrame + ", nameFramework=" + nameFramework + ", status=" + status + "]";
	}
	
}
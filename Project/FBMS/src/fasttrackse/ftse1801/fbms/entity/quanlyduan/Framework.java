package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "framework")
public class Framework implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(name = "ma_framework")
	private String maFramework;
	
	@NotEmpty
	@Column(name = "ten_framework")
	private String tenFramework;

	@Column(name = "is_delete")
	private int isDelete;

	


	public String getMaFramework() {
		return maFramework;
	}

	public void setMaFramework(String maFramework) {
		this.maFramework = maFramework;
	}

	public String getTenFramework() {
		return tenFramework;
	}

	public void setTenFramework(String tenFramework) {
		this.tenFramework = tenFramework;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}

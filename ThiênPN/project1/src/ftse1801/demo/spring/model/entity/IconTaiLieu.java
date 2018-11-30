package ftse1801.demo.spring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icon")
public class IconTaiLieu {
	@Id
	@Column(name = "ma_icon")
	private String maIcon;

	@Column(name = "ten_icon")
	private String tenIcon;

	@Column(name = "link_File")
	private String linkIcon;

	@Column(name = "isDelete")
	private Integer isDelete;

	public String getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(String maIcon) {
		this.maIcon = maIcon;
	}

	public String getTenIcon() {
		return tenIcon;
	}

	public void setTenIcon(String tenIcon) {
		this.tenIcon = tenIcon;
	}

	public String getLinkIcon() {
		return linkIcon;
	}

	public void setLinkIcon(String linkIcon) {
		this.linkIcon = linkIcon;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}

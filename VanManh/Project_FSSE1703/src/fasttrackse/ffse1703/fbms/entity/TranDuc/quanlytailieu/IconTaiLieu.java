package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

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

	@Column(name = "link_file")
	private String linkIcon;

	@Column(name = "isDelete")
	private Integer isDelete;

	@Column(name = "ten_icon")
	private String ten_icon;

	public String getTen_icon() {
		return ten_icon;
	}

	public void setTen_icon(String ten_icon) {
		this.ten_icon = ten_icon;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(String maIcon) {
		this.maIcon = maIcon;
	}

	public String getLinkIcon() {
		return linkIcon;
	}

	public void setLinkIcon(String linkIcon) {
		this.linkIcon = linkIcon;
	}

}

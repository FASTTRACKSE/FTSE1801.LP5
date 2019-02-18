package fasttrackse.ftse1801.fbms.entity.quantritailieu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "icon")
public class IconTaiLieu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_icon")
	private String maIcon;

	@Column(name = "ten_icon")
	private String tenIcon;

	@Column(name = "link_File")
	private String linkIcon;

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

}

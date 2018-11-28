package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Phuong")
public class PhuongPikalong {
	@Id
	private String maPhuong;
	
	private String tenPhuong;
	
	private String maQuanHuyen;

	public String getMaPhuong() {
		return maPhuong;
	}

	public void setMaPhuong(String maPhuong) {
		this.maPhuong = maPhuong;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}
	
	
	
}

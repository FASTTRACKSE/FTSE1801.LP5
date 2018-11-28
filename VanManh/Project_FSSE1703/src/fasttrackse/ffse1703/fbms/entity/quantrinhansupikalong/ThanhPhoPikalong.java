package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TinhThanh")
public class ThanhPhoPikalong {
	@Id
	private String maTinhThanh;
	
	private String tenTinhThanh;

	
	public String getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(String maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	
	
}

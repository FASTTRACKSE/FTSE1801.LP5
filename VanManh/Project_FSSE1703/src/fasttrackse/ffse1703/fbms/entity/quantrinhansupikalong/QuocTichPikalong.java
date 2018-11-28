package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "QuocTich")
public class QuocTichPikalong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String maNuoc;
	
	private String tenNuoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNuoc() {
		return maNuoc;
	}

	public void setMaNuoc(String maNuoc) {
		this.maNuoc = maNuoc;
	}

	public String getTenNuoc() {
		return tenNuoc;
	}

	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}
}

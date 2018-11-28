package fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="du_an")
public class DuAnMinhHQ {
	@Id
	@NotEmpty
	@Column(name="ma_du_an")
	private String maDuAn;
	
	@Column(name="ten_du_an")
	@NotEmpty
	@Length(min=5,max=200)
	private String tenDuAn;
	

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	
}

package fasttrackse.ffse1703.fbms.entity.qlvn1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_nghi_phep")
public class LyDo {
	@Id
	@Column(name="id_nghi")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id_nghi;
	
	@Column(name="ten_loai_nghi")
	public String ten_loai_nghi;

	public int getId_nghi() {
		return id_nghi;
	}

	public void setId_nghi(int id_nghi) {
		this.id_nghi = id_nghi;
	}

	public String getTen_loai_nghi() {
		return ten_loai_nghi;
	}

	public void setTen_loai_nghi(String ten_loai_nghi) {
		this.ten_loai_nghi = ten_loai_nghi;
	}
	
	
}

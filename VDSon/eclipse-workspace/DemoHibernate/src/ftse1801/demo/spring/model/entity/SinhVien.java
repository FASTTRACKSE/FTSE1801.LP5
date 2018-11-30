package ftse1801.demo.spring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sinh_vien")
public class SinhVien {
	@Id
	@Column(name = "MASV")
	private String MASV;
	@Column(name = "TEN")
	private String NAME;
	@Column(name = "Age")
	private int AGE;
	private String image;

	public SinhVien() {

	}

	public SinhVien(String mASV, String nAME, int aGE, String image) {
		super();
		MASV = mASV;
		NAME = nAME;
		AGE = aGE;
		this.image = image;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return MASV + "|" + NAME + "|" + AGE+"|"+image;
	}

}

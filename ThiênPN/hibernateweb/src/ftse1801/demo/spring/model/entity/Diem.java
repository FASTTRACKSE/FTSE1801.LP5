package ftse1801.demo.spring.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
@Entity
@Table(name="diem")
public class Diem implements Serializable{
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="point")
	@Column(name="monhoc")
	private String monHoc;
	@Column(name="diem")
	private int diem;

	public Diem(String monHoc, int diem) {
		super();
		this.monHoc = monHoc;
		this.diem = diem;
	}

	public Diem() {

	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

}

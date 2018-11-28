package myJS;

import javax.faces.bean.ManagedBean;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
@ManagedBean(name="diem")
public class Diem {
	private String monHoc;
	private int diem;


	public Diem() {

	}

	public Diem(String monHoc, int diem) {
		super();
		this.monHoc = monHoc;
		this.diem = diem;
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

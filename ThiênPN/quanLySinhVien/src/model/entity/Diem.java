package model.entity;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
public class Diem {
	private String monHoc;
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

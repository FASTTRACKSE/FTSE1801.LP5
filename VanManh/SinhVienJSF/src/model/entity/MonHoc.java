package model.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MonHoc {
	private String tenMonHoc;
	private String diem;
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getDiem() {
		return diem;
	}
	public void setDiem(String diem) {
		this.diem = diem;
	}
	
	
}

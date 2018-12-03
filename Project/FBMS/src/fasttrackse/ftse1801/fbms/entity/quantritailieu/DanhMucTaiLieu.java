package fasttrackse.ftse1801.fbms.entity.quantritailieu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc")
public class DanhMucTaiLieu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Ma_Danh_Muc")
	private String maDanhMuc;

	@Column(name = "Ten_Danh_Muc")
	private String tenDanhMuc;

	@Column(name = "isDelete")
	private int isDelete;

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	

}

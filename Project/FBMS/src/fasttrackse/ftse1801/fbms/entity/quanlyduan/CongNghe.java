package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "cong_nghe")
public class CongNghe implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_cong_nghe")
	@NotEmpty
	private String maCongNghe;
	
	@NotEmpty
	@Column(name = "ten_cong_nghe")
	private String tenCongNghe;

	@Column(name = "is_delete")
	private int isDelete;

	

	public String getMaCongNghe() {
		return maCongNghe;
	}

	public void setMaCongNghe(String maCongNghe) {
		this.maCongNghe = maCongNghe;
	}

	public String getTenCongNghe() {
		return tenCongNghe;
	}

	public void setTenCongNghe(String tenCongNghe) {
		this.tenCongNghe = tenCongNghe;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}

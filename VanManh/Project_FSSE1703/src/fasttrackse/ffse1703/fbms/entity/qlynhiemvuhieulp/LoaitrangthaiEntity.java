package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "loai_trang_thai")
public class LoaitrangthaiEntity {

	public LoaitrangthaiEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_loai_trang_thai", unique = true, nullable = false, length = 11)
	private int IDtrangthai;

	@Column(name = "loai_trang_thai")
	@NotEmpty
	private String loaiTrangthai;

	public int getIDtrangthai() {
		return IDtrangthai;
	}

	public void setIDtrangthai(int iDtrangthai) {
		IDtrangthai = iDtrangthai;
	}

	public String getLoaiTrangthai() {
		return loaiTrangthai;
	}

	public void setLoaiTrangthai(String loaiTrangthai) {
		this.loaiTrangthai = loaiTrangthai;
	}
}

package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_cong_viec")
public class LoaicongviecEntity {
	public LoaicongviecEntity() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_loai_cong_viec", unique = true, nullable = false, length = 11)
	private int IDcongviec;

	@Column(name = "loai_cong_viec")
	private String loaiCongviec;

	public int getIDcongviec() {
		return IDcongviec;
	}

	public void setIDcongviec(int iDcongviec) {
		IDcongviec = iDcongviec;
	}

	public String getLoaiCongviec() {
		return loaiCongviec;
	}

	public void setLoaiCongviec(String loaiCongviec) {
		this.loaiCongviec = loaiCongviec;
	}

}

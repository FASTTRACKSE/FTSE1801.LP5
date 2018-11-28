package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "xa_phuong")
public class XaPhuongTT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ma_xa_phuong", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maXa;

	@Column(name = "ten_xa_phuong", nullable = false, length = 255)
	@NotEmpty
	private String tenXa;

	@Column(name = "ma_quan_huyen", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maQuanHuyen;
	
	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "xaPhuong")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public XaPhuongTT() {
	}

	

	public String getMaXa() {
		return maXa;
	}



	public void setMaXa(String maXa) {
		this.maXa = maXa;
	}



	public String getTenXa() {
		return tenXa;
	}



	public void setTenXa(String tenXa) {
		this.tenXa = tenXa;
	}




	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}



	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<HoSoNhanVienTT> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVienTT> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

}

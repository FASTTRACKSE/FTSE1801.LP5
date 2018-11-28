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
@Table(name = "quoc_tich")
public class QuocTichTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_quoc_tich", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maQuocTich;

	@Column(name = "ten_quoc_tich", nullable = false, length = 255)
	@NotEmpty
	private String tenQuocTich;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "quocTich")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public QuocTichTT() {
	}

	public String getMaQuocTich() {
		return maQuocTich;
	}

	public void setMaQuocTich(String maQuocTich) {
		this.maQuocTich = maQuocTich;
	}

	public String getTenQuocTich() {
		return tenQuocTich;
	}

	public void setTenQuocTich(String tenQuocTich) {
		this.tenQuocTich = tenQuocTich;
	}

	public List<HoSoNhanVienTT> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVienTT> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

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
@Table(name = "quan_huyen")
public class QuanHuyenTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_quan_huyen", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maQuanHuyen;

	@Column(name = "ten_quan_huyen", nullable = false, length = 255)
	@NotEmpty
	private String tenQuanHuyen;
	
	@Column(name = "ma_thanh_pho", nullable = false, length = 255)
	@NotEmpty
	private String maThanhPho;


	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "quanHuyen")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public QuanHuyenTT() {
	}
	
	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String getMaThanhPho() {
		return maThanhPho;
	}

	public void setMaThanhPho(String maThanhPho) {
		this.maThanhPho = maThanhPho;
	}

	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}

	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}

	public List<HoSoNhanVienTT> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVienTT> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}
}

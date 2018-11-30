package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loai_ky_nang")
public class LoaiKyNang {
	@Id
	@Column(name = "ma_loai_ky_nang", nullable = false)
	private int maLoaiKyNang;

	@Column(name = "ten_loai_ky_nang", nullable = false)
	private String tenLoaiKyNang;

	@OneToMany(mappedBy = "loaiKyNang")
	private List<KyNang> kyNang;
	
	public LoaiKyNang() {
	}

	public List<KyNang> getKyNang() {
		return kyNang;
	}

	public void setKyNang(List<KyNang> kyNang) {
		this.kyNang = kyNang;
	}

	public int getMaLoaiKyNang() {
		return maLoaiKyNang;
	}

	public void setMaLoaiKyNang(int maLoaiKyNang) {
		this.maLoaiKyNang = maLoaiKyNang;
	}

	public String getTenLoaiKyNang() {
		return tenLoaiKyNang;
	}

	public void setTenLoaiKyNang(String tenLoaiKyNang) {
		this.tenLoaiKyNang = tenLoaiKyNang;
	}

}

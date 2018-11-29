package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "dan_toc")
public class DanTocTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_dan_toc", unique = true, nullable = false)
	private int maDanToc;

	@Column(name = "ten_dan_toc", nullable = false, length = 250)
	private String tenDanToc;

	// bi-directional many-to-one association to HopDong 
	@OneToMany(mappedBy = "danToc")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public DanTocTT() {
		super();
	}

	public int getMaDanToc() {
		return maDanToc;
	}

	public void setMaDanToc(int maDanToc) {
		this.maDanToc = maDanToc;
	}

	public String getTenDanToc() {
		return tenDanToc;
	}

	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}

	public List<HoSoNhanVienTT> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVienTT> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

	
}
package fasttrackse.ftse1801.fbms.entity.quanlynhansu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loai_hop_dong")
public class LoaiHopDong {
	@Id
	@Column(name="ma_loai_hop_dong", nullable=false)
	private int maLoaiHopDong;
	
	@Column(name="ten_loai_hop_dong", nullable=false)
	private String tenLoaiHopDong;
	
	public LoaiHopDong() {
	}

	public int getMaLoaiHopDong() {
		return maLoaiHopDong;
	}

	public void setMaLoaiHopDong(int maLoaiHopDong) {
		this.maLoaiHopDong = maLoaiHopDong;
	}

	public String getTenLoaiHopDong() {
		return tenLoaiHopDong;
	}

	public void setTenLoaiHopDong(String tenLoaiHopDong) {
		this.tenLoaiHopDong = tenLoaiHopDong;
	}
	
	
}

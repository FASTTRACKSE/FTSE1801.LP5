package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loaihopdong")
public class LoaiHopDongPikalong {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaLoaiHopDong")
	private int maLoaiHopDong;
	
	
	@Column(name="TenHopDong")
	private String tenHopDong;
	
	
	public LoaiHopDongPikalong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoaiHopDongPikalong(int maLoaiHopDong, String tenHopDong) {
		super();
		this.maLoaiHopDong = maLoaiHopDong;
		this.tenHopDong = tenHopDong;
	}

	public int getMaLoaiHopDong() {
		return maLoaiHopDong;
	}
	public void setMaLoaiHopDong(int maLoaiHopDong) {
		this.maLoaiHopDong = maLoaiHopDong;
	}
	public String getTenHopDong() {
		return tenHopDong;
	}
	public void setTenHopDong(String tenHopDong) {
		this.tenHopDong = tenHopDong;
	}
}

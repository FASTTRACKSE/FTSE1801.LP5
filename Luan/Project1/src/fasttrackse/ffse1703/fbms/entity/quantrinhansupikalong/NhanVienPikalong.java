package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="nhanvien")
public class NhanVienPikalong {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String hoDem;
	
	private String ten;
	
	public NhanVienPikalong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVienPikalong(int id, String hoDem, String ten) {
		super();
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
}

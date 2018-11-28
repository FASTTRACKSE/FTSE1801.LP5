package fasttrackse.ffse1703.fbms.entity.qttl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quyen_truy_cap")
public class Room {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ma_phong_ban")
	private String ma_phong_ban;
	
	@Column(name = "ten_phong_ban")
	private String ten_phong_ban;
	
	public String getMa_phong_ban() {
		return ma_phong_ban;
	}

	public void setMa_phong_ban(String ma_phong_ban) {
		this.ma_phong_ban = ma_phong_ban;
	}

	public String getTen_phong_ban() {
		return ten_phong_ban;
	}

	public void setTen_phong_ban(String ten_phong_ban) {
		this.ten_phong_ban = ten_phong_ban;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Room() {
		super();
	}
	
	public Room ( int id, String ma_phong_ban, String ten_phong_ban) {
		super();
		this.id = id;
		this.ma_phong_ban = ma_phong_ban;
		this.ten_phong_ban = ten_phong_ban;
	}
	
	
}
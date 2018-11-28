package fasttrackse.ffse1703.fbms.entity.qlvn1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "don_nghi")
public class DonNghi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_don")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_don;

	@Column(name="id_nv")
	private int id_nv;

	@Column(name = "ten_nv")
	private String ten_nv;

	@Column(name = "phong_ban")
	private String phong_ban;

	@Column(name = "ly_do")
	private String ly_do;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tg_bat_dau")
	private Date tg_bat_dau;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tg_ket_thuc")
	private Date tg_ket_thuc;

	@Column(name = "tinh_trang")
	private int tinh_trang;
	
	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	
	public int getId_don() {
		return id_don;
	}

	public void setId_don(int id_don) {
		this.id_don = id_don;
	}

	public int getId_nv() {
		return id_nv;
	}

	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}

	public Date getTg_bat_dau() {
		return tg_bat_dau;
	}

	public void setTg_bat_dau(Date tg_bat_dau) {
		this.tg_bat_dau = tg_bat_dau;
	}

	public Date getTg_ket_thuc() {
		return tg_ket_thuc;
	}

	public void setTg_ket_thuc(Date tg_ket_thuc) {
		this.tg_ket_thuc = tg_ket_thuc;
	}

	public int getTinh_trang() {
		return tinh_trang;
	}

	public void setTinh_trang(int tinh_trang) {
		this.tinh_trang = tinh_trang;
	}

	public String getLy_do() {
		return ly_do;
	}

	public void setLy_do(String ly_do) {
		this.ly_do = ly_do;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public String getPhong_ban() {
		return phong_ban;
	}

	public void setPhong_ban(String phong_ban) {
		this.phong_ban = phong_ban;
	}

	@Override
	public String toString() {
		return "DonNghi [id_don=" + id_don + ", id_nv=" + id_nv + ", ten_nv=" + ten_nv + ", phong_ban=" + phong_ban
				+ ", ly_do=" + ly_do + ", tg_bat_dau=" + tg_bat_dau + ", tg_ket_thuc=" + tg_ket_thuc + ", tinh_trang="
				+ tinh_trang + ", ghi_chu=" + ghi_chu + "]";
	}
	
}

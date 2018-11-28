package fasttrackse.ftse1801.fbms.entity.quan_ly_vag_nghi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="don_xin_phep")
public class DonXinNghi {
	@Id
	@GeneratedValue(strategy = GenerationType)
	private int id_don_xin_nghi;
	private String ma_nha_vien;
	private String ma_phong_ban;
	private int id_loai_nghi;
	private String thoi_gian_bat_dau;
	private String thoi_gian_ket_thuc;
	private String ghi_chu;
	private int trang_thai;
	public int getId_don_xin_nghi() {
		return id_don_xin_nghi;
	}
	public void setId_don_xin_nghi(int id_don_xin_nghi) {
		this.id_don_xin_nghi = id_don_xin_nghi;
	}
	public String getMa_nha_vien() {
		return ma_nha_vien;
	}
	public void setMa_nha_vien(String ma_nha_vien) {
		this.ma_nha_vien = ma_nha_vien;
	}
	public String getMa_phong_ban() {
		return ma_phong_ban;
	}
	public void setMa_phong_ban(String ma_phong_ban) {
		this.ma_phong_ban = ma_phong_ban;
	}
	public int getId_loai_nghi() {
		return id_loai_nghi;
	}
	public void setId_loai_nghi(int id_loai_nghi) {
		this.id_loai_nghi = id_loai_nghi;
	}
	public String getThoi_gian_bat_dau() {
		return thoi_gian_bat_dau;
	}
	public void setThoi_gian_bat_dau(String thoi_gian_bat_dau) {
		this.thoi_gian_bat_dau = thoi_gian_bat_dau;
	}
	public String getThoi_gian_ket_thuc() {
		return thoi_gian_ket_thuc;
	}
	public void setThoi_gian_ket_thuc(String thoi_gian_ket_thuc) {
		this.thoi_gian_ket_thuc = thoi_gian_ket_thuc;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public int getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}
}

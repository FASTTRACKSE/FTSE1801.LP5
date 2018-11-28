package fasttrackse.ffse1703.fbms.entity.qlvn2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "so_ngay_nghi")
public class SoNgayNghiEntity {
	@Id
	@Column(name = "ma_nhan_vien")
	private int  maNhanVien;
	
	@Column(name = "so_ngay_da_nghi")
	private int soNgayDaNghi;
	
	@Column(name = "so_ngay_con_lai")
	private int soNgayConLai;

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public int getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(int soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

	

	

	
	
	
}

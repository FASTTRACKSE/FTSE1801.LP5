package fasttrackse.ffse1703.fbms.entity.qlvn1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tinh_trang_nghi")
public class TinhTrangNghi {
	@Id
	@Column(name="id_tinh_trang")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_tinh_trang;
	
	@Column(name="id_nv")
	private int id_nv;
	
	@Column(name="ngay_da_nghi")
	private int ngay_da_nghi;
	
	@Column(name="ngay_con_lai")
	private int ngay_con_lai;

	public int getId_tinh_trang() {
		return id_tinh_trang;
	}

	public void setId_tinh_trang(int id_tinh_trang) {
		this.id_tinh_trang = id_tinh_trang;
	}

	public int getId_nv() {
		return id_nv;
	}

	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}

	public int getNgay_da_nghi() {
		return ngay_da_nghi;
	}

	public void setNgay_da_nghi(int ngay_da_nghi) {
		this.ngay_da_nghi = ngay_da_nghi;
	}

	public int getNgay_con_lai() {
		return ngay_con_lai;
	}

	public void setNgay_con_lai(int ngay_con_lai) {
		this.ngay_con_lai = ngay_con_lai;
	}
	
	
}

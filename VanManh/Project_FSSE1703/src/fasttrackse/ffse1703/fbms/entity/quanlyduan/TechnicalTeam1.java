package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cong_nghe")
public class TechnicalTeam1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_cong_nghe")
	@NotEmpty
	private String ma_cong_nghe;
	
	@NotEmpty
	@Column(name = "ten_cong_nghe")
	private String ten_cong_nghe;

	@Column(name = "is_delete")
	private int is_delete;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="technical",targetEntity=DuAnTeam1.class)
	private Set<DuAnTeam1> duAn;

	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	public String getMa_cong_nghe() {
		return ma_cong_nghe;
	}

	public void setMa_cong_nghe(String ma_cong_nghe) {
		this.ma_cong_nghe = ma_cong_nghe;
	}

	public String getTen_cong_nghe() {
		return ten_cong_nghe;
	}

	public void setTen_cong_nghe(String ten_cong_nghe) {
		this.ten_cong_nghe = ten_cong_nghe;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

}

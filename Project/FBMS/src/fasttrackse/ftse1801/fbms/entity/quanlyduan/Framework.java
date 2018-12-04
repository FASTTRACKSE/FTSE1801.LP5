package fasttrackse.ftse1801.fbms.entity.quanlyduan;

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
@Table(name = "framework")
public class Framework implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(name = "ma_framework")
	private String ma_framework;
	
	@NotEmpty
	@Column(name = "ten_framework")
	private String ten_framework;

	@Column(name = "is_delete")
	private int is_delete;

	@ManyToMany(fetch = FetchType.EAGER,mappedBy="framework",targetEntity=DuAn.class)
	private Set<DuAn> duAn;

	public String getMa_framework() {
		return ma_framework;
	}

	public void setMa_framework(String ma_framework) {
		this.ma_framework = ma_framework;
	}

	public String getTen_framework() {
		return ten_framework;
	}

	public void setTen_framework(String ten_framework) {
		this.ten_framework = ten_framework;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public Set<DuAn> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAn> duAn) {
		this.duAn = duAn;
	}
	
	
}

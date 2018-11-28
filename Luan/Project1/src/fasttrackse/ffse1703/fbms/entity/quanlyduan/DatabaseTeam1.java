package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "co_so_du_lieu")
public class DatabaseTeam1 {
	@Id
	@NotEmpty
	@Column(name = "ma_database")
	private String maDatabase;
	
	@NotEmpty
	@Column(name = "ten_database")
	private String tenDatabase;

	@Column(name = "is_delete")
	private int isDelete;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="database",targetEntity=DuAnTeam1.class)
	private Set<DuAnTeam1> duAn;

	public DatabaseTeam1() {
	}

	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	public String getMaDatabase() {
		return maDatabase;
	}

	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}

	public String getTenDatabase() {
		return tenDatabase;
	}

	public void setTenDatabase(String tenDatabase) {
		this.tenDatabase = tenDatabase;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}

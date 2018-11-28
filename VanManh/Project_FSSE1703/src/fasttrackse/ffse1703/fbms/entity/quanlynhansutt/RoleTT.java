package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleTT implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer maRole;
	private String name;
	private Set<UsersRolesTT> usersRoleses = new HashSet<UsersRolesTT>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_role", unique = true, nullable = false)
	public Integer getMaRole() {
		return maRole;
	}

	public void setMaRole(Integer maRole) {
		this.maRole = maRole;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UsersRolesTT> getUsersRoleses() {
		return this.usersRoleses;
	}

	public void setUsersRoleses(Set<UsersRolesTT> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}

}
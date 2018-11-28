package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UsersRolesTT implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

    private RoleTT role;
	private UserAccountTT user;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_role")
	public RoleTT getRole() {
		return role;
	}

	public void setRole(RoleTT role) {
		this.role = role;
	}

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_tai_khoan")
	public UserAccountTT getUser() {
		return user;
	}

	public void setUser(UserAccountTT user) {
		this.user = user;
	}

}
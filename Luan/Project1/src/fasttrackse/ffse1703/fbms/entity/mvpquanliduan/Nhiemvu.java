package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "qlda_role_assignment")
public class Nhiemvu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_project")
	private Projects projects;
	@ManyToOne
	@JoinColumn(name = "id_employee")
	@NotNull
	private HoSoNhanVienPikalong hoSoNhanVien;
	@ManyToOne
	@JoinColumn(name = "id_role")
	@NotNull
	private Roles roles;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HoSoNhanVienPikalong getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVienPikalong hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}

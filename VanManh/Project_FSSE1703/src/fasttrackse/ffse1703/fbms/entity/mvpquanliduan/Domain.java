package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "qlda_domain")
public class Domain {

	@Id
	@NotEmpty(message = "Mã Nghiệp vụ không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã nghiệp vụ từ 5 đến 10 kí tự")
	@Column(name = "id_domain")
	private String idDomain;

	@NotEmpty(message = "Tên Nghiệp vụ không được để trống!!")
	@Size(min = 5, message = "Tên nghiệp vụ ít nhất 6 kí tự")
	@Column(name = "name_domain")
	private String nameDomain;

	private int status;


	public String getIdDomain() {
		return idDomain;
	}

	public void setIdDomain(String idDomain) {
		this.idDomain = idDomain;
	}

	public String getNameDomain() {
		return nameDomain;
	}

	public void setNameDomain(String nameDomain) {
		this.nameDomain = nameDomain;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

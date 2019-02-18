package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_STATUS")
	private int idStatus;

	@Column(name = "NAME_STATUS")
	private String nameStatus;

	/**
	 * @param idStatus
	 * @param nameStatus
	 */
	public Status(int idStatus, String nameStatus) {
		super();
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
	}

	/**
	 * 
	 */
	public Status() {
	}

	/**
	 * @return the idStatus
	 */
	public int getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus
	 *            the idStatus to set
	 */
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the nameStatus
	 */
	public String getNameStatus() {
		return nameStatus;
	}

	/**
	 * @param nameStatus
	 *            the nameStatus to set
	 */
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

}

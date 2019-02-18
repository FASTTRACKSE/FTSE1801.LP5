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
	private int ID_STATUS;

	@Column(name = "NAME_STATUS")
	private String NAME_STATUS;

	public int getID_STATUS() {
		return ID_STATUS;
	}

	public void setID_STATUS(int iD_STATUS) {
		ID_STATUS = iD_STATUS;
	}

	public String getNAME_STATUS() {
		return NAME_STATUS;
	}

	public void setNAME_STATUS(String nAME_STATUS) {
		NAME_STATUS = nAME_STATUS;
	}

	public Status(int iD_STATUS, String nAME_STATUS) {
		super();
		ID_STATUS = iD_STATUS;
		NAME_STATUS = nAME_STATUS;
	}

	public Status() {
	}

}

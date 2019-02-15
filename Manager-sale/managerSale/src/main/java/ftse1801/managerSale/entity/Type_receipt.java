package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_receipt")
public class Type_receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TYPE_RECEIPT")
	private int ID_TYPE_RECEIPT;

	@Column(name = "NAME_TYPE_RECEIPT")
	private String NAME_TYPE_RECEIPT;

	public int getID_TYPE_RECEIPT() {
		return ID_TYPE_RECEIPT;
	}

	public void setID_TYPE_RECEIPT(int iD_TYPE_RECEIPT) {
		ID_TYPE_RECEIPT = iD_TYPE_RECEIPT;
	}

	public String getNAME_TYPE_RECEIPT() {
		return NAME_TYPE_RECEIPT;
	}

	public void setNAME_TYPE_RECEIPT(String nAME_TYPE_RECEIPT) {
		NAME_TYPE_RECEIPT = nAME_TYPE_RECEIPT;
	}

	public Type_receipt(int iD_TYPE_RECEIPT, String nAME_TYPE_RECEIPT) {
		super();
		ID_TYPE_RECEIPT = iD_TYPE_RECEIPT;
		NAME_TYPE_RECEIPT = nAME_TYPE_RECEIPT;
	}

	public Type_receipt() {
	}

}

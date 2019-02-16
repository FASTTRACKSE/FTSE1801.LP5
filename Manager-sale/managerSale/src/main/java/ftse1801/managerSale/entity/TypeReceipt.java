package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_receipt")
public class TypeReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TYPE_RECEIPT")
	private int idTypeReceipt;

	@Column(name = "NAME_TYPE_RECEIPT")
	private String nameTypeReceipt;

	/**
	 * @param idTypeReceipt
	 * @param nameTypeReceipt
	 */
	public TypeReceipt(int idTypeReceipt, String nameTypeReceipt) {
		super();
		this.idTypeReceipt = idTypeReceipt;
		this.nameTypeReceipt = nameTypeReceipt;
	}

	/**
	 * 
	 */
	public TypeReceipt() {
	}

	/**
	 * @return the idTypeReceipt
	 */
	public int getIdTypeReceipt() {
		return idTypeReceipt;
	}

	/**
	 * @param idTypeReceipt
	 *            the idTypeReceipt to set
	 */
	public void setIdTypeReceipt(int idTypeReceipt) {
		this.idTypeReceipt = idTypeReceipt;
	}

	/**
	 * @return the nameTypeReceipt
	 */
	public String getNameTypeReceipt() {
		return nameTypeReceipt;
	}

	/**
	 * @param nameTypeReceipt
	 *            the nameTypeReceipt to set
	 */
	public void setNameTypeReceipt(String nameTypeReceipt) {
		this.nameTypeReceipt = nameTypeReceipt;
	}

}

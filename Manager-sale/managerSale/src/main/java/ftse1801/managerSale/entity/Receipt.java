package ftse1801.managerSale.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {

	@Id
	@Column(name = "ID_RECEIPT")
	private String idReceipt;

	@Column(name = "ID_EMPL")
	private int idEmpl;

	@Column(name = "ID_CUSTOMER")
	private int idCustomer;

	@Column(name = "VAT")
	private int vat;

	@Column(name = "ID_TYPE_RECEIPT")
	private int idTypeReceipt;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idReceipt
	 * @param idEmpl
	 * @param idCustomer
	 * @param vat
	 * @param idTypeReceipt
	 * @param date
	 * @param delFlg
	 */
	public Receipt(String idReceipt, int idEmpl, int idCustomer, int vat, int idTypeReceipt, Date date, int delFlg) {
		super();
		this.idReceipt = idReceipt;
		this.idEmpl = idEmpl;
		this.idCustomer = idCustomer;
		this.vat = vat;
		this.idTypeReceipt = idTypeReceipt;
		this.date = date;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public Receipt() {
	}

	/**
	 * @return the idReceipt
	 */
	public String getIdReceipt() {
		return idReceipt;
	}

	/**
	 * @param idReceipt
	 *            the idReceipt to set
	 */
	public void setIdReceipt(String idReceipt) {
		this.idReceipt = idReceipt;
	}

	/**
	 * @return the idEmpl
	 */
	public int getIdEmpl() {
		return idEmpl;
	}

	/**
	 * @param idEmpl
	 *            the idEmpl to set
	 */
	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	/**
	 * @return the idCustomer
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/**
	 * @param idCustomer
	 *            the idCustomer to set
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	/**
	 * @return the vat
	 */
	public int getVat() {
		return vat;
	}

	/**
	 * @param vat
	 *            the vat to set
	 */
	public void setVat(int vat) {
		this.vat = vat;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the delFlg
	 */
	public int getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg
	 *            the delFlg to set
	 */
	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}

}

package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CUSTOMER")
	private int idCustomer;

	@Column(name = "NAME_CUSTOMER")
	private String nameCustomer;

	@Column(name = "PHONE_CUSTOMER")
	private String phoneCustomer;

	@Column(name = "CARD_ID")
	private String idCard;

	@Column(name = "ID_GROUPCUST")
	private int idGroupCust;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idCustomer
	 * @param nameCustomer
	 * @param phoneCustomer
	 * @param idCard
	 * @param idGroupCust
	 * @param delFlg
	 */
	public Customer(int idCustomer, String nameCustomer, String phoneCustomer, String idCard, int idGroupCust,
			int delFlg) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.idCard = idCard;
		this.idGroupCust = idGroupCust;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public Customer() {
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
	 * @return the nameCustomer
	 */
	public String getNameCustomer() {
		return nameCustomer;
	}

	/**
	 * @param nameCustomer
	 *            the nameCustomer to set
	 */
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	/**
	 * @return the phoneCustomer
	 */
	public String getPhoneCustomer() {
		return phoneCustomer;
	}

	/**
	 * @param phoneCustomer
	 *            the phoneCustomer to set
	 */
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard
	 *            the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the idGroupCust
	 */
	public int getIdGroupCust() {
		return idGroupCust;
	}

	/**
	 * @param idGroupCust
	 *            the idGroupCust to set
	 */
	public void setIdGroupCust(int idGroupCust) {
		this.idGroupCust = idGroupCust;
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

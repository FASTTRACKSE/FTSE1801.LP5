package ftse1801.managerSale.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMPl")
	private int idEmpi;

	@Column(name = "NAME_EMPl")
	private String maneEmpi;

	@Column(name = "ADDRESS_EMPl")
	private String addressEmpi;

	@Column(name = "PHONE_EMPl")
	private String phoneEmpi;

	@Column(name = "EMAIL_EMPl")
	private String emailEmpi;

	@Column(name = "DATE_ADD")
	private Date dateAdd;

	@Column(name = "CARD_ID")
	private String idCart;

	@Column(name = "ID_POSITION")
	private int idPosition;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idEmpi
	 * @param maneEmpi
	 * @param addressEmpi
	 * @param phoneEmpi
	 * @param emailEmpi
	 * @param dateAdd
	 * @param idCart
	 * @param idPosition
	 * @param delFlg
	 */
	public Employees(int idEmpi, String maneEmpi, String addressEmpi, String phoneEmpi, String emailEmpi, Date dateAdd,
			String idCart, int idPosition, int delFlg) {
		super();
		this.idEmpi = idEmpi;
		this.maneEmpi = maneEmpi;
		this.addressEmpi = addressEmpi;
		this.phoneEmpi = phoneEmpi;
		this.emailEmpi = emailEmpi;
		this.dateAdd = dateAdd;
		this.idCart = idCart;
		this.idPosition = idPosition;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public Employees() {
		super();
	}

	/**
	 * @return the idEmpi
	 */
	public int getIdEmpi() {
		return idEmpi;
	}

	/**
	 * @param idEmpi
	 *            the idEmpi to set
	 */
	public void setIdEmpi(int idEmpi) {
		this.idEmpi = idEmpi;
	}

	/**
	 * @return the maneEmpi
	 */
	public String getManeEmpi() {
		return maneEmpi;
	}

	/**
	 * @param maneEmpi
	 *            the maneEmpi to set
	 */
	public void setManeEmpi(String maneEmpi) {
		this.maneEmpi = maneEmpi;
	}

	/**
	 * @return the addressEmpi
	 */
	public String getAddressEmpi() {
		return addressEmpi;
	}

	/**
	 * @param addressEmpi
	 *            the addressEmpi to set
	 */
	public void setAddressEmpi(String addressEmpi) {
		this.addressEmpi = addressEmpi;
	}

	/**
	 * @return the phoneEmpi
	 */
	public String getPhoneEmpi() {
		return phoneEmpi;
	}

	/**
	 * @param phoneEmpi
	 *            the phoneEmpi to set
	 */
	public void setPhoneEmpi(String phoneEmpi) {
		this.phoneEmpi = phoneEmpi;
	}

	/**
	 * @return the emailEmpi
	 */
	public String getEmailEmpi() {
		return emailEmpi;
	}

	/**
	 * @param emailEmpi
	 *            the emailEmpi to set
	 */
	public void setEmailEmpi(String emailEmpi) {
		this.emailEmpi = emailEmpi;
	}

	/**
	 * @return the dateAdd
	 */
	public Date getDateAdd() {
		return dateAdd;
	}

	/**
	 * @param dateAdd
	 *            the dateAdd to set
	 */
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	/**
	 * @return the idCart
	 */
	public String getIdCart() {
		return idCart;
	}

	/**
	 * @param idCart
	 *            the idCart to set
	 */
	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}

	/**
	 * @return the idPosition
	 */
	public int getIdPosition() {
		return idPosition;
	}

	/**
	 * @param idPosition
	 *            the idPosition to set
	 */
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
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

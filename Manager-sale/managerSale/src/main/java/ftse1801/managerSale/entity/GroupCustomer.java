package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_customer")
public class GroupCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_GROUPCUST")
	private int idGroupCust;

	@Column(name = "NAME_GROUPCUST")
	private String nameGroupCust;

	@Column(name = "DELL_FLG")
	private int delFlg;

	/**
	 * @param idGroupCust
	 * @param nameGroupCust
	 * @param delFlg
	 */
	public GroupCustomer(int idGroupCust, String nameGroupCust, int delFlg) {
		super();
		this.idGroupCust = idGroupCust;
		this.nameGroupCust = nameGroupCust;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public GroupCustomer() {
		super();
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
	 * @return the nameGroupCust
	 */
	public String getNameGroupCust() {
		return nameGroupCust;
	}

	/**
	 * @param nameGroupCust
	 *            the nameGroupCust to set
	 */
	public void setNameGroupCust(String nameGroupCust) {
		this.nameGroupCust = nameGroupCust;
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

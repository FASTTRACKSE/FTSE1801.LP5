package ftse1801.managerSale.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_product")
public class GroupProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_GROUPPRO")
	private int idGroupPro;

	@Column(name = "NAME_GROUPPRO")
	private String nameGroupPro;

	@Column(name = "ID_EMPl")
	private int idEmpi;

	@Column(name = "DATE_ADD")
	private Date dateAdd;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idGroupPro
	 * @param nameGroupPro
	 * @param idEmpi
	 * @param dateAdd
	 * @param delFlg
	 */
	public GroupProduct(int idGroupPro, String nameGroupPro, int idEmpi, Date dateAdd, int delFlg) {
		super();
		this.idGroupPro = idGroupPro;
		this.nameGroupPro = nameGroupPro;
		this.idEmpi = idEmpi;
		this.dateAdd = dateAdd;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public GroupProduct() {
		super();
	}

	/**
	 * @return the idGroupPro
	 */
	public int getIdGroupPro() {
		return idGroupPro;
	}

	/**
	 * @param idGroupPro
	 *            the idGroupPro to set
	 */
	public void setIdGroupPro(int idGroupPro) {
		this.idGroupPro = idGroupPro;
	}

	/**
	 * @return the nameGroupPro
	 */
	public String getNameGroupPro() {
		return nameGroupPro;
	}

	/**
	 * @param nameGroupPro
	 *            the nameGroupPro to set
	 */
	public void setNameGroupPro(String nameGroupPro) {
		this.nameGroupPro = nameGroupPro;
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

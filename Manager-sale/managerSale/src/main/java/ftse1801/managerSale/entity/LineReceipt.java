package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "line_receipt")
public class LineReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LRECEIPT")
	private int idLReceipt;

	@Column(name = "ID_RECEIPT")
	private String idReceipt;

	@Column(name = "ID_PRODUCT")
	private int idProduct;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idLReceipt
	 * @param idReceipt
	 * @param idProduct
	 * @param delFlg
	 */
	public LineReceipt(int idLReceipt, String idReceipt, int idProduct, int delFlg) {
		super();
		this.idLReceipt = idLReceipt;
		this.idReceipt = idReceipt;
		this.idProduct = idProduct;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public LineReceipt() {
	}

	/**
	 * @return the idLReceipt
	 */
	public int getIdLReceipt() {
		return idLReceipt;
	}

	/**
	 * @param idLReceipt
	 *            the idLReceipt to set
	 */
	public void setIdLReceipt(int idLReceipt) {
		this.idLReceipt = idLReceipt;
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
	 * @return the idProduct
	 */
	public int getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct
	 *            the idProduct to set
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the delFlg
	 */
	public int getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg
	 *            the idelFlg to set
	 */
	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}

}

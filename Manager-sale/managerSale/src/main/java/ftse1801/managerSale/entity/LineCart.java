package ftse1801.managerSale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "line_cart")
public class LineCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LINECART")
	private int idLineCart;

	@Column(name = "ID_CART")
	private int idCart;

	@Column(name = "ID_PRODUCT")
	private int idProduct;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "DEL_FLG")
	private int delFlg;

	/**
	 * @param idLineCart
	 * @param idCart
	 * @param idProduct
	 * @param amount
	 * @param delFlg
	 */
	public LineCart(int idLineCart, int idCart, int idProduct, int amount, int delFlg) {
		super();
		this.idLineCart = idLineCart;
		this.idCart = idCart;
		this.idProduct = idProduct;
		this.amount = amount;
		this.delFlg = delFlg;
	}

	/**
	 * 
	 */
	public LineCart() {
		super();
	}

	/**
	 * @return the idLineCart
	 */
	public int getIdLineCart() {
		return idLineCart;
	}

	/**
	 * @param idLineCart
	 *            the idLineCart to set
	 */
	public void setIdLineCart(int idLineCart) {
		this.idLineCart = idLineCart;
	}

	/**
	 * @return the idCart
	 */
	public int getIdCart() {
		return idCart;
	}

	/**
	 * @param idCart
	 *            the idCart to set
	 */
	public void setIdCart(int idCart) {
		this.idCart = idCart;
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
